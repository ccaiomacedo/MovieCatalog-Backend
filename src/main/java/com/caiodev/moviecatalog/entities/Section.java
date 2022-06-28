package com.caiodev.moviecatalog.entities;


import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.util.*;

public class Section implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private List<Topic> topics = new ArrayList<>();

    private Set<Profile> profiles = new HashSet<>();

    public Section() {
    }

    public Section(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id.equals(section.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
