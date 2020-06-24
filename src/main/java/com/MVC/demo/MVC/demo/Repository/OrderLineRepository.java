package com.MVC.demo.MVC.demo.Repository;

import com.MVC.demo.MVC.demo.Models.Order;
import com.MVC.demo.MVC.demo.Models.OrderLines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLines, Integer> {
}
