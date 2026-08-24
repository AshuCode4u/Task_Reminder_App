package com.dev.Task.service;
import com.dev.Task.domain.CreateTaskRequest;
import com.dev.Task.domain.UpdateTaskRequest;
import com.dev.Task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
