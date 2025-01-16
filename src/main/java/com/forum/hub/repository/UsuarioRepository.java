package com.forum.hub.repository;

import com.forum.hub.model.Status;
import com.forum.hub.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.status = :status")
    Page<Usuario> findAllByStatus(Status status, Pageable paginacao);

    Optional<Usuario> findByIdAndStatus(Long id, Status status);
}
