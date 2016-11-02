package com.telstra.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.springboot.domain.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s %s!";
	private final AtomicLong counter = new AtomicLong();

	@Secured("ROLE_NT AUTHORITY\\NETWORK")
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String myName = user.getName(); // get logged in username
		return new Greeting(counter.incrementAndGet(), String.format(template, name, myName));
	}
}