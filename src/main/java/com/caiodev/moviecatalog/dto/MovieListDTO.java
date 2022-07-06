package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.MovieList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Long profileId;

    private List<MovieDTO> movies = new ArrayList<>();

    public MovieListDTO() {

    }

    public MovieListDTO(Long id, String title, Long profileId) {
        this.id = id;
        this.title = title;
        this.profileId = profileId;
    }

    public MovieListDTO(MovieList entity) {
        id = entity.getId();
        title = entity.getTitle();
        profileId = entity.getProfile().getId();
        entity.getMovies().forEach(movie -> this.movies.add(new MovieDTO(movie)));
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }
}
