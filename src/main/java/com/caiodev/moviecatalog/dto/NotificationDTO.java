package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.Notification;
import com.caiodev.moviecatalog.entities.Profile;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String imgUri;
    private String message;
    private Instant moment;
    private Long profileId;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String imgUri, String message, Instant moment, Long profileId) {
        this.id = id;
        this.imgUri = imgUri;
        this.message = message;
        this.moment = moment;
        this.profileId = profileId;
    }

    public NotificationDTO(Notification entity) {
        id = entity.getId();
        imgUri = entity.getImgUri();
        message = entity.getMessage();
        moment = entity.getMoment();
        profileId = entity.getProfile().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
