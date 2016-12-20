package com.springboot.example;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xlightweb.IEventDataSource;
import org.xlightweb.client.HttpClient;

@Configuration
public class EventSourceConfig {

	@Autowired
	private MyEventHandler myEventHandler;

	@Bean
	public IEventDataSource eventSource() {
		HttpClient httpClient = new HttpClient();
		IEventDataSource eventSource = null;
		try {
			eventSource = httpClient.openEventDataSource("http://localhost:8080/api/callevents/6025/yzyahaiffa",
					myEventHandler, new String[] {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventSource;

	}
}
