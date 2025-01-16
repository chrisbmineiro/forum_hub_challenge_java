package com.forum.hub.services;

import com.forum.hub.model.Status;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void realizarAcaoRestrita(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getRole().equals("ADMIN") || !usuario.getRole().equals("MODERADOR")){
            throw new RuntimeException("Acesso negado: Apenas administradores podem realizar esta ação.");
        }

        // Lógica da ação restrita
        System.out.println("Ação restrita realizada por um administrador.");
    }

    @Transactional // Isso garante que a alteração no banco de dados seja persistida
    public void desativarUsuario(Long id) {
        // Verifique se o usuário existe e se está ATIVO antes de alterar o status
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getStatus() == Status.ATIVO) {
            usuario.desativarUsuario(); // Chama o método para mudar o status
            usuarioRepository.save(usuario); // Salva a alteração no banco
        } else {
            throw new RuntimeException("Usuário já está inativo ou não pode ser desativado.");
        }
    }
}