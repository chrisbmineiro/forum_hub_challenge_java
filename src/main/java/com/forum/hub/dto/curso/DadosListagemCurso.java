package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;
import com.forum.hub.model.Curso;

public record DadosListagemCurso(
        String titulo,
        String descricao,
        Integer cargaHoraria,
        Integer totalAulas,
        Categoria categoria
) {
    public DadosListagemCurso(Curso curso) {
        this(curso.getTitulo(), curso.getDescricao(), curso.getCargaHoraria(), curso.getTotalAulas(), curso.getCategoria());
    }
}
