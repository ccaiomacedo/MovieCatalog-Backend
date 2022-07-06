package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.MovieDTO;
import com.caiodev.moviecatalog.dto.MovieListDTO;
import com.caiodev.moviecatalog.entities.*;
import com.caiodev.moviecatalog.repositories.MovieRepository;
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
public class MovieService {

    @Autowired
    MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPaged(Pageable pageable) {
        Page<Movie> page = repository.findAll(pageable);
        return page.map(x -> new MovieDTO(x));
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Optional<Movie> obj = repository.findById(id);
        Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new MovieDTO(entity);
    }

    @Transactional
    public MovieDTO insert(MovieDTO dto) {
        Movie entity = new Movie();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new MovieDTO(entity);
    }

    @Transactional
    public MovieDTO update(MovieDTO dto, Long id) {
        try {
            Movie entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new MovieDTO(entity);
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
            throw new DatabaseException("Integrity violation!");
        }
    }

    private void copyEntityToDto(Movie entity, MovieDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setSynopsis(dto.getSynopsis());
        entity.setImgUri(dto.getImgUri());
        entity.setClassification(dto.getClassification());
        entity.setVideoUri(dto.getVideoUri());
        entity.setHour(dto.getHour());
        entity.setMin(dto.getMin());
        entity.setTrailer(new Trailer(dto.getTrailerId(), null, null, null));
    }


}
