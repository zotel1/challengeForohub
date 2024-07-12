package com.alura.challenge.challengeForohub.repository;

import com.alura.challenge.challengeForohub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long > {
    Usuario findByLogin(String login);
}
