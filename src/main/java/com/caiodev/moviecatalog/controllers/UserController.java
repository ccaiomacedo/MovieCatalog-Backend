package com.caiodev.moviecatalog.controllers;

import com.caiodev.moviecatalog.dto.UserDTO;
import com.caiodev.moviecatalog.dto.UserInsertDTO;
import com.caiodev.moviecatalog.dto.UserUpdateDTO;
import com.caiodev.moviecatalog.entities.User;
import com.caiodev.moviecatalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAllPaged(Pageable pageable) {
        Page<UserDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> Insert(@RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserUpdateDTO dto, @PathVariable Long id) {
        UserDTO newDto = service.update(dto, id);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
