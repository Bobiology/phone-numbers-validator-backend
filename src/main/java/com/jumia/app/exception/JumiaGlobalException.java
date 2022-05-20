package com.jumia.app.exception;

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
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		return new ResponseEntity<Object>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}