package com.caiodev.moviecatalog.entities;

import java.io.Serializable;
import java.util.Objects;

public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double price;
    private String name;

    public Plan(){

    }
    public Plan(Long id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return id.equals(plan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
