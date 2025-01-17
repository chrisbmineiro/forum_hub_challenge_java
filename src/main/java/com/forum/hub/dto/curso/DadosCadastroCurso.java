package com.forum.hub.dto.curso;

import com.forum.hub.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotNull
        Integer cargaHoraria,
        @NotBlank
        Integer totalAulas,
        @NotBlank
        Categoria categoria
) {
}
