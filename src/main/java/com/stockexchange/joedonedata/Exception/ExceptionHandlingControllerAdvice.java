package com.stockexchange.joedonedata.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataException.class)

	public ResponseEntity<Object> exception(final Exception exception, final HttpServletRequest request) {

 
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(exception.getMessage(),
				  HttpStatus.INTERNAL_SERVER_ERROR);

		return responseEntity;
	}

}