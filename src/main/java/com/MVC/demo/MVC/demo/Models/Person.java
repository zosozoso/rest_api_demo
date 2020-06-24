package com.MVC.demo.MVC.demo.Models;

import javax.persistence.*;

@Entity //representacion de una tabla
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private int id;

    @Column(name = "nombre", length = 50)// cada propiedad tiene su column y corresponde a un campo de la tabla
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
