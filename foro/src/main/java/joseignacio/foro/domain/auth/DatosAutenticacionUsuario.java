package joseignacio.foro.domain.auth;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        String login,
        @NotBlank
        String clave
) {}
