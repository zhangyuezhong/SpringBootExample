package com.telstra.springboot.exception;


public class CustomException2 extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException2(String msg, Throwable e) {
		super(msg, e);
	}
	
	public CustomException2() {
		super("");
	}

	public CustomException2(String msg) {
		super(msg);
	}
}
