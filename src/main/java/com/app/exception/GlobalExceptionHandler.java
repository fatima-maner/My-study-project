package com.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<String> handleRuntimeException(RuntimeException e){
	System.out.println("in run time exc handler");
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:"+e.getMessage());
	
}
}
