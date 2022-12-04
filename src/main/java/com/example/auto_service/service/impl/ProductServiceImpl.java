package com.example.auto_service.service.impl;

import com.example.auto_service.model.Product;
import com.example.auto_service.repository.ProductRepository;
import com.example.auto_service.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find product by id " + id));
    }
}
