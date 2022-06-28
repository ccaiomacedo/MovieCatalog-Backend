package com.caiodev.moviecatalog.entities;


import java.io.Serializable;
import java.util.Objects;

public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Offer() {

    }

    public Offer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
