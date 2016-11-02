package com.telstra.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.telstra.springboot.domain.Person;
import com.telstra.springboot.repository.PersonRepository;
import com.telstra.springboot.util.RandomNameGenerator;

@SpringBootApplication
public class SpringPaginationApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringPaginationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringPaginationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			// save a couple of customers
			RandomNameGenerator rnd = new RandomNameGenerator(0);
			for (int i = 0; i < 8000; i++) {
				String fullname = rnd.next();
				String [] names = fullname.split("_");
				repository.save(new Person(names[0], names[1]));
			}
		};
	}
}
