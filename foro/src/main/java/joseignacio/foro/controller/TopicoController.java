package joseignacio.foro.controller;

import jakarta.validation.Valid;
import joseignacio.foro.domain.curso.Curso;
import joseignacio.foro.domain.curso.CursoRepository;
import joseignacio.foro.domain.topico.Topico;
import joseignacio.foro.domain.topico.TopicoRepository;
import joseignacio.foro.domain.topico.dto.DatosActualizarTopico;
import joseignacio.foro.domain.topico.dto.DatosDetalleTopico;
import joseignacio.foro.domain.topico.dto.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    // Dentro de la clase TopicoController
    @PutMapping
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        Curso curso = obtenerOCrearCurso(datosRegistroTopico.curso());
        Topico topico = new Topico(datosRegistroTopico);
        topico.setCurso(curso);
        topicoRepository.save(topico);
        return ResponseEntity.ok("Tópico registrado con éxito.");
    }

    private Curso obtenerOCrearCurso(Curso cursoDelDto) {
        return cursoRepository.findByNombreAndCategoria(cursoDelDto.getNombre(), cursoDelDto.getCategoria())
                .orElseGet(() -> cursoRepository.save(cursoDelDto));
    }

    @GetMapping
    public List<DatosDetalleTopico> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream()
                .map(DatosDetalleTopico::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> buscarTopicoPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(DatosDetalleTopico::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
