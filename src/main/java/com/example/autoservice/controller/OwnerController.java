package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.mapper.OwnerMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.OwnerService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final OrderMapper orderMapper;

    public OwnerController(OwnerService ownerService,
                           OwnerMapper ownerMapper,
                           OrderMapper orderMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto requestDto) {
        return ownerMapper.toDto(ownerService.save(ownerMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id,
                                  @RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerMapper.toModel(requestDto);
        owner.setId(id);
        return ownerMapper.toDto(ownerService.save(owner));
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponseDto> getAllOrdersById(@PathVariable Long id) {
        return ownerService.findById(id).getOrders().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
