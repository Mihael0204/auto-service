package com.example.auto_service.service.impl;

import com.example.auto_service.model.Status;
import com.example.auto_service.model.Task;
import com.example.auto_service.repository.TaskRepository;
import com.example.auto_service.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public Task update(Task task) {
        return repository.save(task);
    }

    @Override
    public Task taskStatus(Long serviceId, Task task, Status status) {
        return repository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find task by id " + id));
    }
}
