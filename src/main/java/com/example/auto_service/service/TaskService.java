package com.example.auto_service.service;

import com.example.auto_service.model.Status;
import com.example.auto_service.model.Task;

public interface TaskService {
    Task save(Task task);

    Task update(Task task);

    Task taskStatus(Long serviceId, Task task, Status status);

    Task findById(Long id);
}
