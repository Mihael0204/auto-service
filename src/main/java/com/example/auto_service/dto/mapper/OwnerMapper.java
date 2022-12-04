package com.example.auto_service.dto.mapper;

import com.example.auto_service.dto.request.OwnerRequestDto;
import com.example.auto_service.dto.response.OwnerResponseDto;
import com.example.auto_service.model.Car;
import com.example.auto_service.model.Order;
import com.example.auto_service.model.Owner;
import com.example.auto_service.service.CarService;
import com.example.auto_service.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    private final CarService carService;
    private final OrderService orderService;

    public OwnerMapper(CarService carService,
                       OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    public Owner toModel(OwnerRequestDto requestDto) {
        Owner owner = new Owner();
        owner.setCars(requestDto.getCarsId().stream()
                .map(carService::findById)
                .collect(Collectors.toList()));
        owner.setOrders(requestDto.getOrdersId().stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return owner;
    }

    public OwnerResponseDto toDto(Owner owner) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(owner.getId());
        dto.setCarsId(owner.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        dto.setOrdersId(owner.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
