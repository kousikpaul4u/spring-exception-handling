package com.demo.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.domain.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(new Date());
		error.setMessage(exception.getMessage());
		error.setUri(request.getRequestURI());
		error.setStatus(Integer.parseInt(HttpStatus.BAD_REQUEST.toString()));
		LOGGER.error("NoSuchElementException: ", exception);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ItemNotFoundExceptions.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ExceptionResponse> itemNotFound(final ItemNotFoundExceptions exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(new Date());
		error.setMessage(exception.getMessage());
		error.setUri(request.getRequestURI());
		error.setStatus(Integer.parseInt(HttpStatus.NOT_FOUND.toString()));
		LOGGER.error("ItemNotFoundExceptions: ", exception);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerExceptions.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleNullPointer(final NullPointerExceptions exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(new Date());
		error.setMessage("" + exception);
		error.setUri(request.getRequestURI());
		error.setStatus(Integer.parseInt(HttpStatus.BAD_REQUEST.toString()));
		LOGGER.error("NullPointerExceptions: ", exception);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(new Date());
		error.setMessage("" + exception);
		error.setUri(request.getRequestURI());
		error.setStatus(Integer.parseInt(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
		LOGGER.error("Exception: ", exception);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
