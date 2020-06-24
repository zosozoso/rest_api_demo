package com.MVC.demo.MVC.demo.Repository;

import com.MVC.demo.MVC.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductRepository extends JpaRepository<Product, Integer> {
}
