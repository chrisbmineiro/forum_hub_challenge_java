package com.forum.hub.dto.usuario;

import com.forum.hub.model.Role;
import com.forum.hub.model.Status;
import com.forum.hub.model.Usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String username,
        String email,
        Role role,
        Status status
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getEmail(), usuario.getRole(), usuario.getStatus());
    }
}
