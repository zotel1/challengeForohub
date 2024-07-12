package com.alura.challenge.challengeForohub.dto;

import com.alura.challenge.challengeForohub.model.Curso;
import com.alura.challenge.challengeForohub.model.Topico;

public record DatosTopicoListado(Long id, String titulo, String mensaje, Curso curso) {
    public DatosTopicoListado(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
