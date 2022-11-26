package com.isvyry.example.scc.controller;

import com.isvyry.example.scc.controller.response.ErrorResponse;
import org.springframework.cloud.config.server.environment.EnvironmentNotFoundException;
import org.springframework.cloud.config.server.environment.NoSuchLabelException;
import org.springframework.cloud.config.server.resource.NoSuchResourceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class DefaultControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchResourceException.class)
    public ErrorResponse noSuchResourceException(HttpServletRequest request, NoSuchResourceException exception) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .error(exception.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchLabelException.class)
    public ErrorResponse noSuchLabelException(HttpServletRequest request, NoSuchLabelException exception) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .error(exception.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EnvironmentNotFoundException.class)
    public ErrorResponse environmentNotFoundException(HttpServletRequest request, EnvironmentNotFoundException exception) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .error(exception.getMessage())
                .path(request.getRequestURI())
                .build();
    }
}
