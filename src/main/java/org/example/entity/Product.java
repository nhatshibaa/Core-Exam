package org.example.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String nsx;
    private String category;
    private Double price;

    @Override
    public String toString() {
        return id + " - " + name + " - " + nsx + " - " + category + " - " + price;
    }

    public Product() {
    }

    public Product(Integer id, String name, String nsx, String category, Double price) {
        this.id = id;
        this.name = name;
        this.nsx = nsx;
        this.category = category;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
