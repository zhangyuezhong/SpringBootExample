package com.telstra.springboot.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello.htm")
	public String hello() throws IOException {

		// render hello.jsp page
		return "hello";
	}

	@RequestMapping(value = "/test.htm")
	public String test() throws IOException {
		int a = 5;
		// just throw exception to test the exceptionhandler mapping
		if (a > 3) {
			throw new IOException("this is io exception");
		}

		// render hello.jsp page
		return "hello";
	}
}