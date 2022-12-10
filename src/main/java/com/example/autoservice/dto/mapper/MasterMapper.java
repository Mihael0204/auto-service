package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper {
    private final OrderService orderService;

    public MasterMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    public Master toModel(MasterRequestDto requestDto) {
        Master master = new Master();
        master.setFullName(requestDto.getFullName());
        master.setCompleteOrders(requestDto.getCompletedOrdersId().stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return master;
    }

    public MasterResponseDto toDto(Master master) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(master.getId());
        dto.setFullName(master.getFullName());
        dto.setCompleteOrdersId(master.getCompleteOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
