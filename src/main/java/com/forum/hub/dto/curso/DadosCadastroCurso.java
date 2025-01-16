package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;

public record DadosCadastroCurso(
        String nome,
        String descricao,
        Categoria categoria
) {
}
