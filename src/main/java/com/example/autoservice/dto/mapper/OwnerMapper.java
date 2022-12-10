package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.OrderService;
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
