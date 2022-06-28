package com.caiodev.moviecatalog.entities;

import java.util.Objects;

public class Trailer {

    private Long id;
    private String videoUri;

    public Trailer() {

    }

    public Trailer(Long id, String videoUri) {
        this.id = id;
        this.videoUri = videoUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trailer trailer = (Trailer) o;
        return id.equals(trailer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
