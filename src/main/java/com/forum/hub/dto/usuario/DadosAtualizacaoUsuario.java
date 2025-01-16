package com.forum.hub.dto.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String username,
        String email,
        String telefone
) {
}
