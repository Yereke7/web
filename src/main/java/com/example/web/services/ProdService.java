package com.example.web.services;

import com.example.web.models.Person;
import com.example.web.models.Product;
import com.example.web.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdService {
    private final ProductRepo productRepo;

    public ProdService( ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Transactional
    public void create(Product product){
        productRepo.save(product);
    }
}
