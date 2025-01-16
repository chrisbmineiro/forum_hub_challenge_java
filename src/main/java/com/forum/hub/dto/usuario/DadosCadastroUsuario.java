package com.forum.hub.dto.usuario;

import com.forum.hub.model.Role;
import com.forum.hub.model.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,

        @NotBlank
        String username,

        @Email @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
        String email,

        @Pattern(regexp = "^\\d{11}$", message = "Telefone inválido")
        String telefone,

        @NotNull
        Role role,

        @NotNull
        Status status
) {
}
