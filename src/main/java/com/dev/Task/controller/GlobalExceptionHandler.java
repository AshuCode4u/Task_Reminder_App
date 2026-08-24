package com.dev.Task.controller;

import com.dev.Task.domain.dto.ErrorDto;
import com.dev.Task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed");

        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity <ErrorDto> handleTaskNotFoundException(TaskNotFoundException ex){
       UUID taskNotFoundId = ex.getId();
       String errorMessage = String.format("Task with id %s not found", taskNotFoundId);
       ErrorDto errorDto = new ErrorDto(errorMessage);
       return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
