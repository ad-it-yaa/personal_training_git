package com.stackroute.newz.util.exception;

public class NewsSourceDoesNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public NewsSourceDoesNotExistsException(String message) {
		super(message);
	}
}
