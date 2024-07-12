package com.alura.challenge.challengeForohub.domain.dto;

import com.alura.challenge.challengeForohub.domain.model.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopicoRegistrado(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        Curso curso
) {
}
