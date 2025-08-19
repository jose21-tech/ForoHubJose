package joseignacio.foro.domain.curso;

import jakarta.persistence.*;
import joseignacio.foro.domain.topico.Topico;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Data
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;
}