package com.forum.hub.controller;

import com.forum.hub.dto.usuario.DadosAtualizacaoUsuario;
import com.forum.hub.dto.usuario.DadosListagemUsuario;
import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import com.forum.hub.model.Status;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import com.forum.hub.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listarUsuarios(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByStatus(Status.ATIVO, paginacao).map(DadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity desativarUsuario(@PathVariable Long id) {
        try {
            usuarioService.desativarUsuario(id);
            return ResponseEntity.ok("Usuário desativado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
