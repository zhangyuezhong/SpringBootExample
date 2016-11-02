package com.telstra.springboot.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String printUser(ModelMap model) {
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String name = user.getName(); // get logged in username
		System.out.println("name=" + name);
		model.addAttribute("username", name);
		StringBuilder sb = new StringBuilder();
		Collection<? extends GrantedAuthority> authors = user.getAuthorities();
		for (GrantedAuthority author : authors) {
			sb.append("<p>").append(author.getAuthority()).append("</p>");
		}
		model.addAttribute("role", sb.toString());

		return "detail";
	}
	
	
	
	
}
