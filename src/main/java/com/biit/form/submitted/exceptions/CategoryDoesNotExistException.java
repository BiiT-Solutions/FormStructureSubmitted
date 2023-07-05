package com.biit.form.submitted.exceptions;

public class CategoryDoesNotExistException extends Exception {
    private static final long serialVersionUID = 1217570595521694572L;

    public CategoryDoesNotExistException(String message) {
        super(message);
    }
}
