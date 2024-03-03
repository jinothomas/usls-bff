package com.usls.common.exception;

public class GroupNotFoundException extends RuntimeException{
	/**
	 * Created by: Jino Thomas
	 * Created date: 03-03-2024
	 */
	private static final long serialVersionUID = 1L;

	public GroupNotFoundException(String error) {
		super(error);
	}
}
