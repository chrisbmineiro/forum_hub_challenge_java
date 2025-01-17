package com.forum.hub.dto.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        Integer cargaHoraria,
        Integer totalAulas
) {
}
