package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.Trailer;

import java.io.Serializable;

public class TrailerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String videoUri;
    private Long movieId;

    public TrailerDTO() {
    }

    public TrailerDTO(Long id, String title, String videoUri, Long movieId) {
        this.id = id;
        this.title = title;
        this.videoUri = videoUri;
        this.movieId = movieId;
    }

    public TrailerDTO(Trailer entity) {
        id = entity.getId();
        title = entity.getTitle();
        videoUri = entity.getVideoUri();
        movieId = entity.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
