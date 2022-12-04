package com.example.auto_service.service;

import com.example.auto_service.model.Product;

public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    Product findById(Long id);
}
