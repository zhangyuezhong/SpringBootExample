package com.telstra.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telstra.springboot.domain.Person;
import com.telstra.springboot.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Page<Person> listAllByPage(Pageable pageable) {
		return this.personRepository.findAll(pageable);

	}
}
