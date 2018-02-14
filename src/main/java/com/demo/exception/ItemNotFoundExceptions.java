package com.demo.exception;

import java.util.NoSuchElementException;

public class ItemNotFoundExceptions extends NoSuchElementException {

	private static final long serialVersionUID = 1L;

	public ItemNotFoundExceptions() {
		super();
	}
	
	public ItemNotFoundExceptions(String msg) {
		super(msg);
	}
}
