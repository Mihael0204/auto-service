package com.example.auto_service.controller;

import com.example.auto_service.dto.mapper.CarMapper;
import com.example.auto_service.dto.request.CarRequestDto;
import com.example.auto_service.dto.response.CarResponseDto;
import com.example.auto_service.model.Car;
import com.example.auto_service.service.CarService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService,
                         CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }


    @PostMapping
    public CarResponseDto createCar(@RequestBody CarRequestDto carRequestDto) {
        Car car = carService.save(carMapper.toModel(carRequestDto));
        return carMapper.toDto(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto) {
        Car car = carMapper.toModel(carRequestDto);
        car.setId(id);
        return carMapper.toDto(car);
    }
}
