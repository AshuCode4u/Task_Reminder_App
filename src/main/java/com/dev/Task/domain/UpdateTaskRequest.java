package com.dev.Task.domain;

import com.dev.Task.domain.entity.TaskPriority;
import com.dev.Task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority

) {
}
