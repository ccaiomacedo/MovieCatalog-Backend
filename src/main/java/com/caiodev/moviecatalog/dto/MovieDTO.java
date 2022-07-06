package com.caiodev.moviecatalog.dto;


import com.caiodev.moviecatalog.entities.Movie;
import com.caiodev.moviecatalog.entities.MovieList;

import java.io.Serializable;

public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String synopsis;
    private String imgUri;
    private String classification;
    private String videoUri;
    private Integer hour;
    private Integer min;

    private Long trailerId;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String synopsis, String imgUri, String classification, String videoUri, Integer hour, Integer min, Long trailerId) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.imgUri = imgUri;
        this.classification = classification;
        this.videoUri = videoUri;
        this.hour = hour;
        this.min = min;
        this.trailerId = trailerId;
    }

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        synopsis = entity.getSynopsis();
        imgUri = entity.getImgUri();
        classification = entity.getClassification();
        videoUri = entity.getVideoUri();
        hour = entity.getHour();
        min = entity.getMin();
        trailerId = entity.getTrailer().getId();
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
    }

}
