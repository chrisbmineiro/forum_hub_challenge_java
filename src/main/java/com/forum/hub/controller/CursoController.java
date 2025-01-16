package com.forum.hub.controller;

import com.forum.hub.dto.DadosListagemCurso;
import com.forum.hub.dto.curso.DadosCadastroCurso;
import com.forum.hub.model.Curso;
import com.forum.hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCurso(@RequestBody DadosCadastroCurso dados) {
        repository.save(new Curso(dados));
    }

    // TODO: arrumar essa bagaça
    @GetMapping
    public Page<DadosListagemCurso> listarCursos(@PageableDefault(sort = {"categoria"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCurso::new);
    }
}
