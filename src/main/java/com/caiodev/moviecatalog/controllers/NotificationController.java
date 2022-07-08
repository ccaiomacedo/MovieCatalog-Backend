package com.caiodev.moviecatalog.controllers;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping()
    public ResponseEntity<Page<NotificationDTO>> findAllPaged(Pageable pageable) {
        Page<NotificationDTO> page = service.notificationForCurrentUser(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping()
    public ResponseEntity<NotificationDTO> insert(@RequestBody NotificationDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NotificationDTO> update(@RequestBody NotificationDTO dto, @PathVariable Long id) {
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
