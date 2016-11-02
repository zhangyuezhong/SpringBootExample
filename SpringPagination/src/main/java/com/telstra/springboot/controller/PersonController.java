package com.telstra.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.springboot.domain.Person;
import com.telstra.springboot.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value="/persons",method=RequestMethod.GET)
	public Page<Person> list( Pageable pageable){
		return  personService.listAllByPage(pageable);
	}
}
