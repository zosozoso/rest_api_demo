package com.MVC.demo.MVC.demo.Models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private int id;

    @Column(name = "name", length = 50)// cada propiedad tiene su column y corresponde a un campo de la tabla
    private String name;

    @Column(name = "price")
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
