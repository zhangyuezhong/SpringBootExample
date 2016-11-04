package com.telstra.springboot.exception;


public class CustomException1 extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException1(String msg, Throwable e) {
		super(msg, e);
	}
	public CustomException1() {
		super("");
	}

	public CustomException1(String msg) {
		super(msg);
	}
}
