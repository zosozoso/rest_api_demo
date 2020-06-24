package com.MVC.demo.MVC.demo.Controllers;

import com.MVC.demo.MVC.demo.Models.Person;
import com.MVC.demo.MVC.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas") //puerta de entrada para hacer llamada en postman
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping // C
    public void insert(@RequestBody Person p){
        personRepository.save(p);
    }

    @GetMapping // R
    public List<Person> list(){
        return personRepository.findAll();
    }

    @PutMapping // U
    public void modify(@RequestBody Person p){
        personRepository.save(p);
    }

    @DeleteMapping(value = "/{id}")// D
    public void delete(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }
}
