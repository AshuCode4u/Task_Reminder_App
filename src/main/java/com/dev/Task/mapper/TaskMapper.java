package com.dev.Task.mapper;

import com.dev.Task.domain.CreateTaskRequest;
import com.dev.Task.domain.UpdateTaskRequest;
import com.dev.Task.domain.dto.CreateTaskRequestDto;
import com.dev.Task.domain.dto.TaskDto;
import com.dev.Task.domain.dto.UpdateTaskRequestDto;
import com.dev.Task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
