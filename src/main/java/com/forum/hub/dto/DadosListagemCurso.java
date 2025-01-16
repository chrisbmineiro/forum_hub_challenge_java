package com.forum.hub.dto;

import com.forum.hub.model.Categoria;
import com.forum.hub.model.Curso;

public record DadosListagemCurso(
        String nome,
        String descricao,
        Categoria categoria
){
    public DadosListagemCurso(Curso curso) {
        this(curso.getNome(), curso.getDescricao(), curso.getCategoria());
    }
}
