package com.caiodev.moviecatalog.entities;

import java.util.Objects;

public class Movie {

    private Long id;
    private String title;
    private String synopse;
    private String imgUri;
    private String classification;
    private String videoUri;
    private Integer hour;
    private Integer min;

    public Movie(){

    }

    public Movie(Long id, String title, String synopse, String imgUri, String classification, String videoUri, Integer hour, Integer min) {
        this.id = id;
        this.title = title;
        this.synopse = synopse;
        this.imgUri = imgUri;
        this.classification = classification;
        this.videoUri = videoUri;
        this.hour = hour;
        this.min = min;
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

    public String getSynopse() {
        return synopse;
    }

    public void setSynopse(String synopse) {
        this.synopse = synopse;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
