package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.TaskRequestDto;
import com.example.autoservice.dto.response.TaskResponseDto;
import com.example.autoservice.model.Task;
import com.example.autoservice.service.MasterService;
import com.example.autoservice.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final OrderService orderService;
    private final MasterService masterService;

    public TaskMapper(OrderService orderService, MasterService masterService) {
        this.orderService = orderService;
        this.masterService = masterService;
    }

    public Task toModel(TaskRequestDto requestDto) {
        Task task = new Task();
        task.setMaster(masterService.findById(requestDto.getMasterId()));
        task.setOrder(orderService.findById(requestDto.getOrderId()));
        task.setPrice(requestDto.getPrice());
        task.setStatus(requestDto.getStatus());
        return task;
    }

    public TaskResponseDto toDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setPrice(task.getPrice());
        taskResponseDto.setMasterId(task.getMaster().getId());
        taskResponseDto.setOrderId(task.getOrder().getId());
        taskResponseDto.setStatus(task.getStatus().toString());
        return taskResponseDto;
    }
}
