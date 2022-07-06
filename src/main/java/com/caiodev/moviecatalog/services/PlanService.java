package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.PlanDTO;
import com.caiodev.moviecatalog.entities.Plan;
import com.caiodev.moviecatalog.repositories.PlanRepository;
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
public class PlanService {

    @Autowired
    PlanRepository repository;

    @Transactional(readOnly = true)
    public Page<PlanDTO> findAllPaged(Pageable pageable) {
        Page<Plan> page = repository.findAll(pageable);
        return page.map(x -> new PlanDTO(x));
    }

    @Transactional(readOnly = true)
    public PlanDTO findById(Long id) {
        Optional<Plan> obj = repository.findById(id);
        Plan entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new PlanDTO(entity);
    }

    @Transactional
    public PlanDTO insert(PlanDTO dto) {
        Plan entity = new Plan();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new PlanDTO(entity);
    }

    @Transactional
    public PlanDTO update(PlanDTO dto, Long id) {
        try {
            Plan entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new PlanDTO(entity);
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


    private void copyEntityToDto(Plan entity, PlanDTO dto) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
    }


}
