package com.MVC.demo.MVC.demo.Controllers;

import com.MVC.demo.MVC.demo.Models.Order;
import com.MVC.demo.MVC.demo.Models.OrderLines;
import com.MVC.demo.MVC.demo.Models.Person;
import com.MVC.demo.MVC.demo.Models.Product;
import com.MVC.demo.MVC.demo.Repository.OrderLineRepository;
import com.MVC.demo.MVC.demo.Repository.OrderRepository;
import com.MVC.demo.MVC.demo.Repository.PersonRepository;
import com.MVC.demo.MVC.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    @PostMapping("/order")
    public Order addOrder(@RequestParam(name = "person_id") Integer personId){

        Optional<Person> person = personRepository.findById(personId);
        Order order = new Order();
        person.ifPresent(person1->{
            order.setPerson(person1);
        });
        orderRepository.save(order);
        return order; //return the order cuz we need to know the id to use  on the orderline
    }

    @PostMapping("/order_line")
    public void addOrderLine(@RequestParam(name = "id_order")Integer orderId,
                            @RequestParam(name = "id_product")Integer productId){
        Optional<Order> order = orderRepository.findById(orderId); //fetch for an order
        OrderLines orderLines = new OrderLines();
        order.ifPresent(order1 ->{
            orderLines.setOrder(order1);
        });
        Optional<Product> product = productRepository.findById(productId); //fetch for a product
        product.ifPresent(product1 ->{
            orderLines.setProduct(product1);
        });

        float total = order.get().getTotalQuote();
        total = total + product.get().getPrice();
        order.get().setTotalQuote(total);
        orderRepository.save(order.get());
        orderLineRepository.save(orderLines);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable()Integer id){
        return orderRepository.findById(id).get() ;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable(name = "id")Integer id){
        orderRepository.deleteById(id);
    }





}
