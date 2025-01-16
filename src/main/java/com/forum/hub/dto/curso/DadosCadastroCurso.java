package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        Integer cargaHoraria,
        @NotBlank
        Integer totalAulas,
        @NotBlank
        Categoria categoria
) {
}
