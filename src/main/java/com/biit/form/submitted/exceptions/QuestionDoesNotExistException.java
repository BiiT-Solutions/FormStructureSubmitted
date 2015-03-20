package com.biit.form.submitted.exceptions;

public class QuestionDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1217570595521694572L;

	public QuestionDoesNotExistException(String message) {
		super(message);
	}
}
