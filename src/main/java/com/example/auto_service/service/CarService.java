package com.example.auto_service.service;

import com.example.auto_service.model.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Car save(Car car);

    Car update(Car car);

    Car findById(Long id);
}
