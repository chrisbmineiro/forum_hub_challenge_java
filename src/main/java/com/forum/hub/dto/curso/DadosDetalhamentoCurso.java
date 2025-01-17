package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;
import com.forum.hub.model.Curso;

public record DadosDetalhamentoCurso(
        Long id,
        String titulo,
        String descricao,
        Integer cargaHoraria,
        Integer totalAulas,
        Categoria categoria,
        Boolean ativo
) {
    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getId(), curso.getTitulo(), curso.getDescricao(), curso.getCargaHoraria(), curso.getTotalAulas(), curso.getCategoria(), curso.getAtivo());
    }
}
