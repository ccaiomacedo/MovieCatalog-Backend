package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.SectionDTO;
import com.caiodev.moviecatalog.entities.Section;
import com.caiodev.moviecatalog.entities.User;
import com.caiodev.moviecatalog.repositories.SectionRepository;
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

import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    SectionRepository repository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<SectionDTO> findAllPaged(Pageable pageable) {
        Page<Section> page = repository.findAll(pageable);
        return page.map(x -> new SectionDTO(x));
    }

    @Transactional(readOnly = true)
    public SectionDTO findById(Long id) {
        Optional<Section> obj = repository.findById(id);
        Section entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new SectionDTO(entity);
    }

    @Transactional
    public SectionDTO insert(SectionDTO dto) {
        User user = authService.authenticated();
        if (user.hasHole("ROLE_ADMIN")) {
            Section entity = new Section();
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new SectionDTO(entity);
        } else {
            throw new ForbiddenException("Access denied");
        }

    }

    @Transactional
    public SectionDTO update(SectionDTO dto, Long id) {
        try {
            User user = authService.authenticated();
            if (user.hasHole("ROLE_ADMIN")) {
                Section entity = repository.getOne(id);
                copyEntityToDto(entity, dto);
                entity = repository.save(entity);
                return new SectionDTO(entity);
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


    private void copyEntityToDto(Section entity, SectionDTO dto) {
        entity.setName(dto.getName());
    }


}
