package com.telstra.springboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.telstra.springboot.domain.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}