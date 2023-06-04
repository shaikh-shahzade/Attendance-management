package com.org.attendance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.attendance.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFound(ResourceNotFoundException rexp)
	{
		ApiResponse apiR = new ApiResponse(rexp.getMessage(),false);
		return new ResponseEntity<ApiResponse>(apiR , HttpStatus.NOT_FOUND);
	}
}
