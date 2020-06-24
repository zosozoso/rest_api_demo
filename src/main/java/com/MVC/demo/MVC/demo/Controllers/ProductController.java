package com.MVC.demo.MVC.demo.Controllers;

import com.MVC.demo.MVC.demo.Models.Product;
import com.MVC.demo.MVC.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository; //???

    @PostMapping
    public void addProduct(@RequestParam(name="name",required = true)String name,
                            @RequestParam(name="price",required = true)Float price){

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productRepository.save(p);

    }

    @GetMapping
    public List<Product> getProducts(){

        return productRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Product> getProduct(@RequestParam(value = "id")Integer id){

        return productRepository.findById(id);
    }
    //@PatchMapping



}
