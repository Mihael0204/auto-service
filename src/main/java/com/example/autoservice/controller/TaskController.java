package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.TaskMapper;
import com.example.autoservice.dto.request.TaskRequestDto;
import com.example.autoservice.dto.response.TaskResponseDto;
import com.example.autoservice.model.Status;
import com.example.autoservice.model.Task;
import com.example.autoservice.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskMapper taskMapper;
    private final TaskService taskService;

    public TaskController(TaskMapper taskMapper,
                          TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDto create(@RequestBody TaskRequestDto taskRequestDto) {
        return taskMapper.toDto(taskService.save(taskMapper.toModel(taskRequestDto)));
    }

    @PutMapping("/{id}")
    public TaskResponseDto update(@PathVariable Long id,
                                  @RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskMapper.toModel(taskRequestDto);
        task.setId(id);
        return taskMapper.toDto(task);
    }

    @GetMapping("/status/{id}")
    public TaskResponseDto updateStatus(@PathVariable Long id,
                                        @RequestBody Status status) {
        Task task = taskService.findById(id);
        task.setId(id);
        task.setStatus(status);
        return taskMapper.toDto(taskService
                .save(task));
    }
}
