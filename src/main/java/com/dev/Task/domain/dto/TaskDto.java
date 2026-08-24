package com.dev.Task.domain.dto;

import com.dev.Task.domain.entity.TaskPriority;
import com.dev.Task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
