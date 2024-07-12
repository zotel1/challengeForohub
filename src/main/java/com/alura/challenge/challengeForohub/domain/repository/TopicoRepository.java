package com.alura.challenge.challengeForohub.domain.repository;

import com.alura.challenge.challengeForohub.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
