package com.MVC.demo.MVC.demo.Controllers;

import com.MVC.demo.MVC.demo.Models.Order;
import com.MVC.demo.MVC.demo.Models.OrderLines;
import com.MVC.demo.MVC.demo.Models.Person; //importo por que estan en paquetes separados
import com.MVC.demo.MVC.demo.Models.Product;
import com.MVC.demo.MVC.demo.Repository.OrderLineRepository;
import com.MVC.demo.MVC.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DemoController {

    @Autowired
    private PersonRepository personRepository; //repository of table Person

    @Autowired
    private OrderLineRepository orderLineRepository; //repository of table Order

    @Autowired
  //  private ProductRepository ProductRepository; //repository of table product


    @PostMapping("/order")
    public Order AddOrder(){
        Person p= new Person();
        p.setNombre("Frank Zappa");
        //personRepository.save();

      //  model.addAttribute("name", name); // link db with view

        Product product = new Product();
        product.setName("caca");
      //  productRepository.save(product);

        Product product2 = new Product();
        product2.setName("pipi");

        Order order = new Order();

        OrderLines orderLines1 = new OrderLines();
        orderLines1.setOrder(order);
        orderLines1.setProduct(product);
       // orderLineRepository.save(orderLines1);

        OrderLines orderLines2 = new OrderLines();
        orderLines2.setOrder(order);
        orderLines2.setProduct(product2);
       // orderLineRepository.save(orderLines2);

         return null;

      //  return "greeting";
    }

    @GetMapping("/persons")
    public @ResponseBody Iterable<Person> GetAllPerson(){ //returns a  json

        return personRepository.findAll();
    }

    @GetMapping("/person")
    public @ResponseBody Optional<Person> GetPerson(@RequestParam(name="id", required=true)int id) {

        return personRepository.findById(id);
    }
}
