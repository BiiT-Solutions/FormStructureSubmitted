package com.biit.form.submitted.exceptions;

public class GroupDoesNotExistException extends Exception{
	private static final long serialVersionUID = -2238485520110406605L;

	public GroupDoesNotExistException(String message) {
		super(message);
	}
}
