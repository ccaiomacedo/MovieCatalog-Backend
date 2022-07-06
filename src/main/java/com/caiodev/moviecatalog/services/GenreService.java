package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.*;
import com.caiodev.moviecatalog.entities.Genre;
import com.caiodev.moviecatalog.repositories.GenreRepository;
import com.caiodev.moviecatalog.services.exceptions.DatabaseException;
import com.caiodev.moviecatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GenreService {


    @Autowired
    public GenreRepository repository;


    @Transactional(readOnly = true)
    public Page<GenreDTO> findAllPaged(Pageable pageable) {
        Page<Genre> list = repository.findAll(pageable);
        return list.map(x -> new GenreDTO(x));
    }

    @Transactional(readOnly = true)
    public GenreDTO findById(Long id) {
        Optional<Genre> obj = repository.findById(id);
        Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new GenreDTO(entity);
    }

    @Transactional
    public GenreDTO insert(GenreDTO genreDto) {
        Genre genre = new Genre();
        copyEntityToDto(genreDto, genre);
        genre = repository.save(genre);
        return new GenreDTO(genre);
    }

    @Transactional
    public GenreDTO update(GenreDTO dto, Long id) {
        try {
            Genre genre = repository.getOne(id);
            copyEntityToDto(dto, genre);
            genre = repository.save(genre);
            return new GenreDTO(genre);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    public void copyEntityToDto(GenreDTO genreDTO, Genre genre) {
        genre.setName(genreDTO.getName());
    }
}
