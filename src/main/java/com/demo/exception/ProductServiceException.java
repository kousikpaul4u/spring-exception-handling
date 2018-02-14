package com.demo.exception;

public class ProductServiceException extends Exception {
	
	private static final long serialVersionUID = -9079454849611061074L;

	public ProductServiceException() {
		super();
	}

	public ProductServiceException(final String message) {
		super(message);
	}
}
