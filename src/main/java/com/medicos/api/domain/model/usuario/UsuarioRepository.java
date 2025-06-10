package com.medicos.api.domain.model.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método necessário para buscarmos o usuário no banco de dados pelo email.
    Optional<Usuario> findByEmailIgnoreCase(String email);
    // optional para podemos utilizar uma exceção mais customizada.
}
