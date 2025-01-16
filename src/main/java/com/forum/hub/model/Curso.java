package com.forum.hub.model;

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
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;
    @Column(name = "total_aulas", nullable = false)
    private Integer totalAulas;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso() {
    }

    public Curso(DadosCadastroCurso dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.cargaHoraria = dados.cargaHoraria();
        this.totalAulas = dados.totalAulas();
        this.categoria = dados.categoria();
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
}
