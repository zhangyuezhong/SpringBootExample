package com.telstra.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;

@Configuration
// @EnableJms no longer need as boot find the class //JmsAutoConfiguration and
// JmsAnnotationDrivenConfiguration
public class JmsConfig implements JmsListenerConfigurer {

	/// to override the default

	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		// TODO Auto-generated method stub

	}

	// @Bean
	// public JmsListenerContainerFactory<?>
	// jmsListenerContainerFactory(ConnectionFactory connectionFactory,
	// DefaultJmsListenerContainerFactoryConfigurer configurer) {
	// DefaultJmsListenerContainerFactory factory = new
	// DefaultJmsListenerContainerFactory();
	// // This provides all boot's default to this factory, including the
	// // message converter
	// configurer.configure(factory, connectionFactory);
	// // You could still override some of Boot's default if necessary.
	// return factory;
	// }

}
