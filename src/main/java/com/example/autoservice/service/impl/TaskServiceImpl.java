package com.example.autoservice.service.impl;

import com.example.autoservice.model.Status;
import com.example.autoservice.model.Task;
import com.example.autoservice.repository.TaskRepository;
import com.example.autoservice.service.TaskService;
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
