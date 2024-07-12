package com.alura.challenge.challengeForohub.domain.model;

import com.alura.challenge.challengeForohub.domain.dto.DatosTopicoActualizado;
import com.alura.challenge.challengeForohub.domain.dto.DatosTopicoRegistrado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosTopicoRegistrado datosTopicoRegistrado) {
        this.titulo = datosTopicoRegistrado.titulo();
        this.mensaje = datosTopicoRegistrado.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.curso = datosTopicoRegistrado.curso();
    }

    public void actualizarInfo(DatosTopicoActualizado datosTopicoActualizado) {
        if (datosTopicoActualizado.titulo() != null) {
            this.titulo = datosTopicoActualizado.titulo();
        }

        if (datosTopicoActualizado.mensaje() != null) {
            this.mensaje = datosTopicoActualizado.mensaje();
        }
    }

}
