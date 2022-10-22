package com.example.web.repositories;

import com.example.web.models.Person;
import com.example.web.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
}
