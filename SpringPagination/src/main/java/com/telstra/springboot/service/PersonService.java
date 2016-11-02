package com.telstra.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.telstra.springboot.domain.Person;

public interface PersonService {
	Page<Person> listAllByPage(Pageable pageable);
}
