package com.alura.challenge.challengeForohub.domain.dto;

import com.alura.challenge.challengeForohub.domain.model.Curso;
import com.alura.challenge.challengeForohub.domain.model.Topico;

public record DatosTopicoListado(Long id, String titulo, String mensaje, Curso curso) {
    public DatosTopicoListado(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
