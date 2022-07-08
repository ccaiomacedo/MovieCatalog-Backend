package com.caiodev.moviecatalog.controllers;

import com.caiodev.moviecatalog.dto.MovieListDTO;
import com.caiodev.moviecatalog.services.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/movieLists")
public class MovieListController {

    @Autowired
    private MovieListService service;

    @GetMapping()
    public ResponseEntity<Page<MovieListDTO>> findAllPaged(Pageable pageable) {
        Page<MovieListDTO> page = service.findAllPaged(pageable);
        String teste;
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieListDTO> findById(@PathVariable Long id) {
        MovieListDTO dto = service.findById(id);
        String teste;
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping()
    public ResponseEntity<MovieListDTO> insert(@RequestBody MovieListDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieListDTO> update(@RequestBody MovieListDTO dto, @PathVariable Long id) {
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
