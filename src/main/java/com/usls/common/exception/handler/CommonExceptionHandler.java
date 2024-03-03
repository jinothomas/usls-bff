package com.usls.common.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usls.common.exception.GroupNotFoundException;
import com.usls.common.exception.RoleNotFoundException;
import com.usls.common.exception.UserNotFoundException;

@ControllerAdvice
public class CommonExceptionHandler {
	
	private static final String MESSAGE = "message";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, "Something Went Wrong!");
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, exception.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException exception) {
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, exception.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GroupNotFoundException.class)
	public ResponseEntity<Object> handleGroupNotFoundException(GroupNotFoundException exception) {
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, exception.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
