package com.forum.hub.model;

import com.forum.hub.dto.curso.DadosAtualizacaoCurso;
import com.forum.hub.dto.curso.DadosCadastroCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "total_aulas")
    private Integer totalAulas;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean ativo;

    public Curso() {
    }

    public Curso(DadosCadastroCurso dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.cargaHoraria = dados.cargaHoraria();
        this.totalAulas = dados.totalAulas();
        this.categoria = dados.categoria();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Integer getTotalAulas() {
        return totalAulas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizacaoCurso dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.cargaHoraria() != null) {
            this.cargaHoraria = dados.cargaHoraria();
        }
        if (dados.totalAulas() != null) {
            this.totalAulas = dados.totalAulas();
        }
    }

    public void excluirCurso() {
        this.ativo = false;
    }
}
