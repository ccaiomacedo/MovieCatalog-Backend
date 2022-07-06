package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.NotificationDTO;
import com.caiodev.moviecatalog.dto.ProfileDTO;
import com.caiodev.moviecatalog.dto.RoleDTO;
import com.caiodev.moviecatalog.dto.UserDTO;
import com.caiodev.moviecatalog.entities.*;
import com.caiodev.moviecatalog.repositories.NotificationRepository;
import com.caiodev.moviecatalog.repositories.ProfileRepository;
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
public class ProfileService {

    @Autowired
    ProfileRepository repository;

    @Autowired
    NotificationRepository notificationRepository;

    @Transactional(readOnly = true)
    public Page<ProfileDTO> findAllPaged(Pageable pageable) {
        Page<Profile> page = repository.findAll(pageable);
        return page.map(x -> new ProfileDTO(x));
    }

    @Transactional(readOnly = true)
    public ProfileDTO findById(Long id) {
        Optional<Profile> obj = repository.findById(id);
        Profile entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new ProfileDTO(entity);
    }

    @Transactional
    public ProfileDTO insert(ProfileDTO dto) {
        Profile entity = new Profile();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new ProfileDTO(entity);
    }

    @Transactional
    public ProfileDTO update(ProfileDTO dto, Long id) {
        try {
            Profile entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new ProfileDTO(entity);
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


    private void copyEntityToDto(Profile entity, ProfileDTO dto) {
        entity.setName(dto.getName());
        entity.setUser(new User(dto.getUserId(), null, null, null, null));

        entity.getNotifications().clear();

        for (NotificationDTO notificationDTO : dto.getNotifications()) {
            Notification notification = notificationRepository.getOne(notificationDTO.getId());
            entity.getNotifications().add(notification);
        }

    }


}
