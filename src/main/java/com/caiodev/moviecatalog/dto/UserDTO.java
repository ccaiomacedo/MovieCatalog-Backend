package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private Long plan;

    private Set<RoleDTO> roles = new HashSet<>();

    private List<ProfileDTO> profiles = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, Long plan) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.plan = plan;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        plan = entity.getPlan().getId();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
        entity.getProfiles().forEach(profile -> this.profiles.add(new ProfileDTO(profile)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPlan() {
        return plan;
    }

    public void setPlan(Long plan) {
        this.plan = plan;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }
}
