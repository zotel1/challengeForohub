package com.alura.challenge.challengeForohub.domain.repository;

import com.alura.challenge.challengeForohub.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long > {
    Usuario findByLogin(String login);
}
