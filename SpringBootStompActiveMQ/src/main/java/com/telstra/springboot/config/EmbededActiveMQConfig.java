package com.telstra.springboot.config;

import org.apache.activemq.xbean.BrokerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = { "spring.activemq.broker.embedded" }, havingValue = "true", matchIfMissing = false)
public class EmbededActiveMQConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public BrokerFactoryBean broker() {
		BrokerFactoryBean factory = new BrokerFactoryBean();
		factory.setStart(true);
		factory.setConfig(context.getResource("classpath:com/telstra/springboot/config/activemq.xml"));
		factory.setSystemExitOnShutdown(false);
		factory.setSystemExitOnStop(false);

		return factory;
	}
}
