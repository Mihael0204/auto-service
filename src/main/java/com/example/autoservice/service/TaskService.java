package com.example.autoservice.service;

import com.example.autoservice.model.Status;
import com.example.autoservice.model.Task;

public interface TaskService {
    Task save(Task task);

    Task update(Task task);

    Task taskStatus(Long serviceId, Task task, Status status);

    Task findById(Long id);
}
