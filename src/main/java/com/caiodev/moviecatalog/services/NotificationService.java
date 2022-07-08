package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.entities.*;
import com.caiodev.moviecatalog.entities.Notification;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.services.exceptions.DatabaseException;
import com.caiodev.moviecatalog.services.exceptions.ForbiddenException;
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
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = repository.find(user, pageable);
        return page.map(x -> new NotificationDTO(x));
    }

    @Transactional
    public NotificationDTO insert(NotificationDTO dto) {
        User user = authService.authenticated();
        Notification entity = new Notification();
        copyEntityToDto(entity, dto);
        if (user.hasHole("ROLE_ADMIN")) {
            entity = repository.save(entity);
            return new NotificationDTO(entity);
        } else {
            throw new ForbiddenException("Access denied");
        }
    }

    @Transactional
    public NotificationDTO update(NotificationDTO dto, Long id) {
        try {
            User user = authService.authenticated();
            Notification entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            if (user.hasHole("ROLE_ADMIN")) {
                entity = repository.save(entity);
                return new NotificationDTO(entity);
            } else {
                throw new ForbiddenException("Access denied");
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    public void delete(Long id) {
        try {
            User user = authService.authenticated();
            if (user.hasHole("ROLE_ADMIN")) {
                repository.deleteById(id);
            } else {
                throw new ForbiddenException("Access denied");
            }
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
