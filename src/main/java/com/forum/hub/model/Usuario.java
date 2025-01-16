package com.forum.hub.model;

import com.forum.hub.dto.usuario.DadosAtualizacaoUsuario;
import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String username;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Usuario(){}

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.username = dados.username();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.role = Role.USER;
        this.status = Status.ATIVO;
    }

    public String getUsername() {
        return username;
    }

    public String getTelefone() {
        return telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.username() != null) {
            this.username = dados.username();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void desativarUsuario() {
        if (this.status == Status.ATIVO) {
            this.status = Status.INATIVO;
        }
    }
}
