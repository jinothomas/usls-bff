package com.usls.common.exception;

public class RoleNotFoundException extends RuntimeException{
	/**
	 * Created by: Jino Thomas
	 * Created date: 03-03-2024
	 */
	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(String error) {
		super(error);
	}
}
