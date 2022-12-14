package com.example.autoservice.service.impl;

import com.example.autoservice.model.Car;
import com.example.autoservice.repository.CarRepository;
import com.example.autoservice.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find car by id " + id));
    }
}
