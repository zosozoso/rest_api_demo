package com.MVC.demo.MVC.demo.Repository;

import com.MVC.demo.MVC.demo.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
