package com.forum.hub.dto.usuario;

import com.forum.hub.model.Status;

public record DadosCadastroUsuario(
        String nome,
        String email,
        String senha,
        String telefone,
        Status status
) {
}
