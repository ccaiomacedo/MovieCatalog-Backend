package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.Profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfileDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long userId;
    private List<NotificationDTO> notifications = new ArrayList<>();

    public ProfileDTO() {
    }

    public ProfileDTO(Long id, String name, Long userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public ProfileDTO(Profile entity) {
        id = entity.getId();
        name = entity.getName();
        userId = entity.getUser().getId();
        entity.getNotifications().forEach(notification -> this.notifications.add(new NotificationDTO(notification)));
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

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<NotificationDTO> getNotifications() {
        return notifications;
    }
}
