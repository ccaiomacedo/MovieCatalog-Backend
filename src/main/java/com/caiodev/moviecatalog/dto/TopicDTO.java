package com.caiodev.moviecatalog.dto;

import com.caiodev.moviecatalog.entities.Topic;

import java.io.Serializable;

public class TopicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;

    public TopicDTO() {
    }

    public TopicDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public TopicDTO(Topic entity) {
        id = entity.getId();
        title = entity.getTitle();
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
}
