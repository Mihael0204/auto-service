package com.example.auto_service.controller;

import com.example.auto_service.dto.mapper.OrderMapper;
import com.example.auto_service.dto.mapper.ProductMapper;
import com.example.auto_service.dto.request.OrderRequestDto;
import com.example.auto_service.dto.request.ProductRequestDto;
import com.example.auto_service.dto.response.OrderResponseDto;
import com.example.auto_service.model.Order;
import com.example.auto_service.model.Status;
import com.example.auto_service.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ProductMapper productMapper;

    public OrderController(OrderMapper orderMapper,
                           OrderService orderService,
                           ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.productMapper = productMapper;
    }


    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto orderRequestDto) {
        return orderMapper.toDto(orderService.save(orderMapper.toModel(orderRequestDto)));
    }

    @PostMapping("/products/{id}")
    public OrderResponseDto addProductToOrder(@PathVariable Long id,
                                              @RequestBody ProductRequestDto productRequestDto) {
        Order order = orderService.addProductToOrder(id, productMapper.toModel(productRequestDto));
        return orderMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderMapper.toModel(orderRequestDto);
        order.setId(id);
        return orderMapper.toDto(orderService.save(order));
    }

    @PutMapping("/status/{id}")
    public OrderResponseDto updateStatus(@PathVariable Long id,
                                         @RequestBody OrderRequestDto orderRequestDto,
                                         @RequestBody Status status) {
        Order order = orderMapper.toModel(orderRequestDto);
        order.setId(id);
        order.setStatus(status);
        return orderMapper.toDto(orderService.save(order));
    }

    @GetMapping("/{id}/price")
    public OrderResponseDto getOrderPrice(@PathVariable Long id) {
        return orderMapper.toDto(orderService.getOrderPrice(id));
    }
}
