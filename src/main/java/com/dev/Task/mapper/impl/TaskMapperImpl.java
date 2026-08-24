package com.dev.Task.mapper.impl;

import com.dev.Task.domain.CreateTaskRequest;
import com.dev.Task.domain.UpdateTaskRequest;
import com.dev.Task.domain.dto.CreateTaskRequestDto;
import com.dev.Task.domain.dto.TaskDto;
import com.dev.Task.domain.dto.UpdateTaskRequestDto;
import com.dev.Task.domain.entity.Task;
import com.dev.Task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new  TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
