package com.example.autoservice.service;

import com.example.autoservice.model.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Car save(Car car);

    Car update(Car car);

    Car findById(Long id);
}
