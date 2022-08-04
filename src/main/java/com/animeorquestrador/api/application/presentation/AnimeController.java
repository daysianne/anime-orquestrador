package com.animeorquestrador.api.application.presentation;


import com.animeorquestrador.api.application.mapper.AnimeMapper;
import com.animeorquestrador.api.application.presentation.representation.AnimeRequestRepresentation;
import com.animeorquestrador.api.application.presentation.representation.AnimeResponseRepresentation;
import com.animeorquestrador.api.domain.domain.Anime;
import com.animeorquestrador.api.domain.port.AnimeRepository;
import com.animeorquestrador.api.domain.service.AnimeService;
import com.animeorquestrador.api.domain.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@RestController
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<AnimeResponseRepresentation> BuscarPorId(@PathVariable(value = "id") Long id) {
        var animeById = animeService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(AnimeMapper.paraRepresentacao(animeById));
    }

    @GetMapping
    public List<Anime> buscarTodos() {
        return animeService.buscarTodos();

    }

    @PostMapping
    public ResponseEntity<AnimeResponseRepresentation> salvar(@RequestBody AnimeRequestRepresentation body) {
        var anime = animeService.salvar(AnimeMapper.paraDominio(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover (@PathVariable Long codigo) {
        this.animeService.delete(codigo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Anime> atualizar(@PathVariable Long codigo, @RequestBody Anime anime) {
        Anime animeSalva = animeService.atualizar(codigo, anime);

        return ResponseEntity.ok(animeSalva);
    }

}
