package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.Profile;
import com.caiodev.moviecatalog.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String email;
    private Long plan;

    private Set<RoleDTO> roles = new HashSet<>();

    private List<ProfileDTO> profiles = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email, Long plan) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.plan = plan;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        username = entity.getUsername();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
