package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.entities.*;
import com.caiodev.moviecatalog.entities.Notification;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.services.exceptions.DatabaseException;
import com.caiodev.moviecatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository repository;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> findAllPaged(Pageable pageable) {
        Page<Notification> page = repository.findAll(pageable);
        return page.map(x -> new NotificationDTO(x));
    }

    @Transactional(readOnly = true)
    public NotificationDTO findById(Long id) {
        Optional<Notification> obj = repository.findById(id);
        Notification entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new NotificationDTO(entity);
    }

    @Transactional
    public NotificationDTO insert(NotificationDTO dto) {
        Notification entity = new Notification();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new NotificationDTO(entity);
    }

    @Transactional
    public NotificationDTO update(NotificationDTO dto, Long id) {
        try {
            Notification entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new NotificationDTO(entity);
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


    private void copyEntityToDto(Notification entity, NotificationDTO dto) {
        entity.setImgUri(dto.getImgUri());
        entity.setMessage(dto.getMessage());
        entity.setMoment(dto.getMoment());
        entity.setProfile(new Profile(dto.getProfileId(), null, null));
    }


}
