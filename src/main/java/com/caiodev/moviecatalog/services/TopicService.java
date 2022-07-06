package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.dto.TopicDTO;
import com.caiodev.moviecatalog.entities.MovieList;
import com.caiodev.moviecatalog.entities.Notification;
import com.caiodev.moviecatalog.entities.Topic;
import com.caiodev.moviecatalog.entities.User;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.repositories.TopicRepository;
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
public class TopicService {

    @Autowired
    TopicRepository repository;


    @Transactional(readOnly = true)
    public Page<TopicDTO> findAllPaged(Pageable pageable) {
        Page<Topic> page = repository.findAll(pageable);
        return page.map(x -> new TopicDTO(x));
    }

    @Transactional(readOnly = true)
    public TopicDTO findById(Long id) {
        Optional<Topic> obj = repository.findById(id);
        Topic entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new TopicDTO(entity);
    }

    @Transactional
    public TopicDTO insert(TopicDTO dto) {
        Topic entity = new Topic();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new TopicDTO(entity);
    }

    @Transactional
    public TopicDTO update(TopicDTO dto, Long id) {
        try {
            Topic entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new TopicDTO(entity);
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


    private void copyEntityToDto(Topic entity, TopicDTO dto) {
        entity.setTitle(dto.getTitle());
    }


}
