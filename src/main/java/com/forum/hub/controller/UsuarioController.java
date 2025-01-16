package com.forum.hub.controller;

import com.forum.hub.dto.usuario.DadosAtualizacaoUsuario;
import com.forum.hub.dto.usuario.DadosListagemUsuario;
import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listarUsuarios(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }
}
