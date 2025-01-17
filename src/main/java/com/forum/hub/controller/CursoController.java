package com.forum.hub.controller;

import com.forum.hub.dto.curso.DadosAtualizacaoCurso;
import com.forum.hub.dto.curso.DadosListagemCurso;
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
        System.out.println(dados);
        repository.save(new Curso(dados));
    }

    @GetMapping
    public Page<DadosListagemCurso> listarCursos(@PageableDefault(sort = {"categoria"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCurso::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCurso(@RequestBody DadosAtualizacaoCurso dados) {
        var curso = repository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCurso(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        curso.excluirCurso();
    }
}
