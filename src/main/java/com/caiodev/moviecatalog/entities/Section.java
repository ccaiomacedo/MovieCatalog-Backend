package com.caiodev.moviecatalog.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "tb_section")
public class Section implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "tb_section_topic", joinColumns = @JoinColumn(name = "section_id"), inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private List<Topic> topics = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_section_profile", joinColumns = @JoinColumn(name = "section_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
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
