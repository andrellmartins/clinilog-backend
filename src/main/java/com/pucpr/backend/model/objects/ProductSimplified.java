package com.pucpr.backend.model.objects;

import java.io.Serializable;

public class ProductSimplified implements Serializable {
    private String title;
    private Integer available_quantity;

    public ProductSimplified() {
    }

    public ProductSimplified(String title, Integer available_quantity) {
        this.title = title;
        this.available_quantity = available_quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Integer available_quantity) {
        this.available_quantity = available_quantity;
    }
}
