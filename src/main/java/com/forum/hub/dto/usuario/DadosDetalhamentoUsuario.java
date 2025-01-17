package com.forum.hub.dto.usuario;

import com.forum.hub.model.Usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String username,
        String email,
        String telefone,
        String role,
        String status
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getEmail(), usuario.getTelefone(), usuario.getRole().name(), usuario.getStatus().name());
    }
}
