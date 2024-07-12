package com.alura.challenge.challengeForohub.controller;

import com.alura.challenge.challengeForohub.dto.DatosDetalleTopico;
import com.alura.challenge.challengeForohub.dto.DatosTopicoActualizado;
import com.alura.challenge.challengeForohub.dto.DatosTopicoListado;
import com.alura.challenge.challengeForohub.dto.DatosTopicoRegistrado;
import com.alura.challenge.challengeForohub.model.Topico;
import com.alura.challenge.challengeForohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopicoRegistrado datosTopicoRegistrado, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datosTopicoRegistrado);
        topicoRepository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopicoListado>> datosTopicosListado(@PageableDefault(size = 5, sort = {"curso"})Pageable pageable) {
        var page = topicoRepository.findAll(pageable).map(DatosTopicoListado::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosTopicoActualizado datosTopicoActualizado) {
        var topico = topicoRepository.getReferenceById(datosTopicoActualizado.id());
        topico.actualizarInfo(datosTopicoActualizado);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.noContent().build();
        }
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }


}
