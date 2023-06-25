package com.condo.management.facilityrestservices.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Map<String, String>> handleGeneralExceptions(Exception ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Map<String, String>> handleRuntimeExceptions(RuntimeException ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = Collections.singletonList(ex.getFieldError().getDefaultMessage());
		return new ResponseEntity<Object>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
	}

	private Map<String, String> getErrorsMap(List<String> errors) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", errors.get(0));
		return errorResponse;
	}
}