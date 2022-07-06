package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.*;
import com.caiodev.moviecatalog.entities.Plan;
import com.caiodev.moviecatalog.entities.Profile;
import com.caiodev.moviecatalog.entities.Role;
import com.caiodev.moviecatalog.entities.User;
import com.caiodev.moviecatalog.repositories.ProfileRepository;
import com.caiodev.moviecatalog.repositories.RoleRepository;
import com.caiodev.moviecatalog.repositories.UserRepository;
import com.caiodev.moviecatalog.services.exceptions.DatabaseException;
import com.caiodev.moviecatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    public UserRepository repository;

    @Autowired
    public BCryptPasswordEncoder encoder;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public ProfileRepository profileRepository;


    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDTO(x));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO userDto) {
        User user = new User();
        copyEntityToDto(userDto, user);
        user.setPassword(encoder.encode(userDto.getPassword()));
        user = repository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(UserUpdateDTO dto, Long id) {
        try {
            User user = repository.getOne(id);
            copyEntityToDto(dto, user);
            user = repository.save(user);
            return new UserDTO(user);
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

    public void copyEntityToDto(UserDTO userDTO, User user) {
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPlan(new Plan(userDTO.getPlan(), null, null));

        user.getRoles().clear();

        for (RoleDTO roleDTO : userDTO.getRoles()) {
            Role role = roleRepository.getOne(roleDTO.getId());
            user.getRoles().add(role);
        }
        user.getProfiles().clear();

        for (ProfileDTO profileDTO : userDTO.getProfiles()) {
            Profile profile = profileRepository.getOne(profileDTO.getId());
            user.getProfiles().add(profile);
        }

    }
}
