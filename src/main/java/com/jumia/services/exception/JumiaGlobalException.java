package com.jumia.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JumiaGlobalException {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
		return new ResponseEntity<Object>("Record not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = JumiaNoContentException.class)
	public ResponseEntity<Object> exception(JumiaNoContentException exception) {
		return new ResponseEntity<Object>("No content", HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = JumiaInternalErrorException.class)
	public ResponseEntity<Object> exception(JumiaInternalErrorException exception) {
		return new ResponseEntity<Object>("No content", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}