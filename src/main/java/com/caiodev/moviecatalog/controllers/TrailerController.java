package com.caiodev.moviecatalog.controllers;

import com.caiodev.moviecatalog.dto.TrailerDTO;
import com.caiodev.moviecatalog.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService service;

    @GetMapping()
    public ResponseEntity<Page<TrailerDTO>> findAllPaged(Pageable pageable) {
        Page<TrailerDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrailerDTO> findById(@PathVariable Long id) {
        TrailerDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping()
    public ResponseEntity<TrailerDTO> insert(@RequestBody TrailerDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TrailerDTO> update(@RequestBody TrailerDTO dto, @PathVariable Long id) {
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
