package com.caiodev.moviecatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String imgUri;
    private String message;
    private Instant moment;

    public Notification() {
    }

    public Notification(Long id, String imgUri, String message, Instant moment) {
        this.id = id;
        this.imgUri = imgUri;
        this.message = message;
        this.moment = moment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
