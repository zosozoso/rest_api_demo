package com.MVC.demo.MVC.demo.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity //Es una entidad de la base de datos // its an entity in the database
@Table(name="couriers") //aqui mapeamos // we use this to mao to the database
public class Courier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

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
