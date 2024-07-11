package com.alura.challenge.challengeForohub.dto;

import com.alura.challenge.challengeForohub.model.Curso;
import com.alura.challenge.challengeForohub.model.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(String titulo, String mensaje, LocalDateTime fechaDeCreaacion, Curso curso) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion(), topico.getCurso());
    }

}
