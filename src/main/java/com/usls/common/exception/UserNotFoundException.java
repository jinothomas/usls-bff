package com.usls.common.exception;

public class UserNotFoundException extends RuntimeException{
	/**
	 * Created by: Jino Thomas
	 * Created date: 25-02-2024
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String error) {
		super(error);
	}
}
