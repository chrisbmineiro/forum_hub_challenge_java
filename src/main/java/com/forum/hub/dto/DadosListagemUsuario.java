package com.forum.hub.dto;

import com.forum.hub.model.Status;
import com.forum.hub.model.Usuario;

public record DadosListagemUsuario(
        String nome,
        String email,
        Status status
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getStatus());
    }
}
