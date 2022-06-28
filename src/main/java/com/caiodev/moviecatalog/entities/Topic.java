package com.caiodev.moviecatalog.entities;

import java.io.Serializable;
import java.util.Objects;

public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;

    public Topic(){

    }

    public Topic(Long id, String title) {
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
        Topic topic = (Topic) o;
        return id.equals(topic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
