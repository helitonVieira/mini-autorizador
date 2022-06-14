package com.heliton.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class RestExceptionHandler {
	
	@ExceptionHandler(com.heliton.services.exceptions.ObjectNotFoundException.class)
	public ResponseEntity<com.heliton.exceptions.StandardError> objectNotFound(com.heliton.services.exceptions.ObjectNotFoundException e, HttpServletRequest request) {
		
		com.heliton.exceptions.StandardError err = new com.heliton.exceptions.StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(com.heliton.services.exceptions.DataIntegrityException.class)
	public ResponseEntity<com.heliton.exceptions.StandardError> dataIntegrity(com.heliton.services.exceptions.DataIntegrityException e, HttpServletRequest request) {
		
		com.heliton.exceptions.StandardError err = new com.heliton.exceptions.StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<com.heliton.exceptions.StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		com.heliton.exceptions.ValidationError err = new com.heliton.exceptions.ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	

}
