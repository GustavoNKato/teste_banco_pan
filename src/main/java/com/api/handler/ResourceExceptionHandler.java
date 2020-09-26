package com.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.exception.ResourceNotFoundException;
import com.api.models.ErrorDetail;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ErrorDetail handleResourceNotFoundException(ResourceNotFoundException e) {
		return new ErrorDetail(e.getMessage());
	}
}
