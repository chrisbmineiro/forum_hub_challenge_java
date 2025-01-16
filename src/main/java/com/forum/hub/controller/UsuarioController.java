package com.forum.hub.controller;

import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }
}
