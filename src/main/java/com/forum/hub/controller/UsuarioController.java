package com.forum.hub.controller;

import com.forum.hub.dto.DadosListagemUsuario;
import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<DadosListagemUsuario> listarUsuarios() {
        return repository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }
}
