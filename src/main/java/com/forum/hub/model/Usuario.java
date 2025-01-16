package com.forum.hub.model;

import com.forum.hub.dto.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Usuario(){}

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.status = dados.status();
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
}
