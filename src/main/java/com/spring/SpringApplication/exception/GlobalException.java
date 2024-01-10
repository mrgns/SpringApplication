package com.spring.SpringApplication.exception;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {

	private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String exceptionHandler(Exception exc, Model model,HttpServletRequest request) {
		log.error("Number Format Exception occurred while processing request {} {}: {}", request.getMethod(), request.getRequestURI(), exc.getMessage());
		log.error("GlobalException exception :",exc);
		return "Exception";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Boolean> handleValidationExceptions(Exception exc) {
		log.error(exc.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	@ResponseBody
	public ResponseEntity<Boolean> handleNumberFormatExceptions(Exception exc) {
		log.error(exc.getMessage());
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}

}
