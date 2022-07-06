package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.dto.TrailerDTO;
import com.caiodev.moviecatalog.entities.*;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.repositories.TrailerRepository;
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
public class TrailerService {

    @Autowired
    TrailerRepository repository;


    @Transactional(readOnly = true)
    public Page<TrailerDTO> findAllPaged(Pageable pageable) {
        Page<Trailer> page = repository.findAll(pageable);
        return page.map(x -> new TrailerDTO(x));
    }

    @Transactional(readOnly = true)
    public TrailerDTO findById(Long id) {
        Optional<Trailer> obj = repository.findById(id);
        Trailer entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new TrailerDTO(entity);
    }

    @Transactional
    public TrailerDTO insert(TrailerDTO dto) {
        Trailer entity = new Trailer();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new TrailerDTO(entity);
    }

    @Transactional
    public TrailerDTO update(TrailerDTO dto, Long id) {
        try {
            Trailer entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new TrailerDTO(entity);
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


    private void copyEntityToDto(Trailer entity, TrailerDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setVideoUri(dto.getVideoUri());
        entity.setMovie(new Movie(dto.getMovieId(), null, null, null, null, null, null, null, null, null));
    }


}
