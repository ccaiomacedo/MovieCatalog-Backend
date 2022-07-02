package com.caiodev.moviecatalog.dto;


import com.caiodev.moviecatalog.entities.Plan;

import java.io.Serializable;

public class PlanDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double price;
    private String name;

    public PlanDTO() {
    }

    public PlanDTO(Long id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public PlanDTO(Plan entity){
        id = entity.getId();
        price = entity.getPrice();
        name = entity.getName();
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
}
