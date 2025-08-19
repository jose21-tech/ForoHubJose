package joseignacio.foro.domain.topico.dto;

import jakarta.validation.constraints.NotNull;
import joseignacio.foro.domain.curso.Curso;
import joseignacio.foro.domain.topico.StatusTopico;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        StatusTopico status,
        String autor,
        Curso curso
) {
}