package com.alura.challenge.challengeForohub.infra.errores;

import org.springframework.validation.FieldError;

public record DatosValidacionDeError(String campo, String message) {
    public DatosValidacionDeError(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
