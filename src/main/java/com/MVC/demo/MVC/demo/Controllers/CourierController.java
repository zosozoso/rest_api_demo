package com.MVC.demo.MVC.demo.Controllers;

import com.MVC.demo.MVC.demo.Models.Courier;
import com.MVC.demo.MVC.demo.Repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/couriers")
public class CourierController {

    @Autowired //injectar la instancia del repositorio
    private CourierRepository courierRepository;

    @PostMapping
    public void addCourier (@RequestParam(name = "name",required = true)String name){

        Courier c = new Courier();
        c.setName(name);
        courierRepository.save(c);
    }

    @GetMapping
    public List<Courier> getCouriers() {

       return courierRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Courier getCourier(@PathVariable("id")Integer id){
      return courierRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(value = "/{id}")
    public void updateCourier(@RequestParam(name = "name",required = true)String name,@PathVariable("id")Integer id){
        Courier c = courierRepository.getOne(id);
        c.setName(name);
        courierRepository.save(c);

    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourier(@PathVariable("id") Integer id){
        courierRepository.deleteById(id);
    }
}
