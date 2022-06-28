package com.caiodev.moviecatalog.entities;

import java.io.Serializable;
import java.util.Objects;

public class MovieList implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;

    public MovieList(){

    }

    public MovieList(Long id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieList movieList = (MovieList) o;
        return id.equals(movieList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
