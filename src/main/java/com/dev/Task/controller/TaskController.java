package com.dev.Task.controller;

import com.dev.Task.domain.CreateTaskRequest;
import com.dev.Task.domain.UpdateTaskRequest;
import com.dev.Task.domain.dto.CreateTaskRequestDto;
import com.dev.Task.domain.dto.TaskDto;
import com.dev.Task.domain.dto.UpdateTaskRequestDto;
import com.dev.Task.domain.entity.Task;
import com.dev.Task.mapper.TaskMapper;
import com.dev.Task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
       @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
       CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
       Task task = taskService.createTask(createTaskRequest);
       TaskDto createdTaskDto = taskMapper.toDto(task);
       return new  ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List <Task> tasks = taskService.listTasks();
        List <TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity <TaskDto> updateTask(
            @PathVariable UUID taskId,
           @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ){
       UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
       Task task = taskService.updateTask(taskId, updateTaskRequest);
       TaskDto taskDto = taskMapper.toDto(task);
       return ResponseEntity.ok(taskDto);

    }
    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable UUID taskId
    ){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
