package com.example.auto_service.dto.mapper;

import com.example.auto_service.dto.request.CarRequestDto;
import com.example.auto_service.dto.response.CarResponseDto;
import com.example.auto_service.model.Car;
import com.example.auto_service.service.OwnerService;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final OwnerService ownerService;

    public CarMapper(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    public Car toModel(CarRequestDto requestDto) {
        Car car = new Car();
        car.setBrand(requestDto.getBrand());
        car.setModel(requestDto.getModel());
        car.setYearOfRelease(requestDto.getYearOfRelease());
        car.setNumber(requestDto.getNumber());
        car.setOwner(ownerService.findById(requestDto.getOwnerId()));
        return car;
    }

    public CarResponseDto toDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(car.getId());
        carResponseDto.setBrand(car.getBrand());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setYearOfRelease(car.getYearOfRelease());
        carResponseDto.setNumber(car.getNumber());
        carResponseDto.setOwnerId(car.getOwner().getId());
        return carResponseDto;
    }
}
