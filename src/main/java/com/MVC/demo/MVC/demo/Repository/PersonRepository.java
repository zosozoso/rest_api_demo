package com.MVC.demo.MVC.demo.Repository;

import com.MVC.demo.MVC.demo.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Integer> { // heredamos de otra interfaz

    //Hacemos los querys por aqui, CRUD

}
