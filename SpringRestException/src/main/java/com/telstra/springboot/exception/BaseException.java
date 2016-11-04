package com.telstra.springboot.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(String msg, Throwable e) {
		super(msg, e);
	}

	public BaseException() {
		super("");
	}

	public BaseException(String msg) {
		super(msg);
	}
}
