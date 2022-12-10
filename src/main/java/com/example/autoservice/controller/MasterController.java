package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.MasterMapper;
import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.service.MasterService;
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
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterMapper masterMapper;
    private final OrderMapper orderMapper;

    public MasterController(MasterService masterService,
                            MasterMapper masterMapper,
                            OrderMapper orderMapper) {
        this.masterService = masterService;
        this.masterMapper = masterMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public MasterResponseDto createMaster(@RequestBody MasterRequestDto masterRequestDto) {
        return masterMapper.toDto(masterService.save(masterMapper.toModel(masterRequestDto)));
    }

    @PutMapping("/{id}")
    public MasterResponseDto update(@PathVariable Long id,
                                    @RequestBody MasterRequestDto masterRequestDto) {
        Master master = masterMapper.toModel(masterRequestDto);
        master.setId(id);
        return masterMapper.toDto(masterService.save(master));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> getCompleteOrdersById(@PathVariable Long id) {
        return masterService.findReadyOrder(id)
                .stream().map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/salary")
    public double getSalary(@PathVariable Long masterId) {
        return masterService.getSalary(masterId);
    }
}
