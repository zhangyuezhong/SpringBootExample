package com.telstra.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxWsConfig {

	@Bean
	public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
		SimpleJaxWsServiceExporter explorter = new SimpleJaxWsServiceExporter();
		explorter.setBaseAddress("http://localhost:9080/");
		return explorter;
	}
}
