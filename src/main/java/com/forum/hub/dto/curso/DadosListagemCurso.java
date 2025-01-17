package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;
import com.forum.hub.model.Curso;

public record DadosListagemCurso(
        Long id,
        String titulo,
        String descricao,
        Integer cargaHoraria,
        Integer totalAulas,
        Categoria categoria,
        Boolean ativo
) {
    public DadosListagemCurso(Curso curso) {
        this(curso.getId(),curso.getTitulo(), curso.getDescricao(), curso.getCargaHoraria(), curso.getTotalAulas(), curso.getCategoria(), curso.getAtivo());
    }
}
