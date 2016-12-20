package com.springboot.example;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootSseClientApplication {

	public static void main(String[] args) {
		// System.setProperty(ClientBuilder.JAXRS_DEFAULT_CLIENT_BUILDER_PROPERTY,
		// "org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder");
		ApplicationContext ctx = SpringApplication.run(SpringBootSseClientApplication.class, args);

		try {
			TimeUnit.MINUTES.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
