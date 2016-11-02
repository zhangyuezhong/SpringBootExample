package com.telstra.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Value("${stomp.relay.host}")
	private String stompRelayHost;

	@Value("${stomp.relay.port}")
	private int stompRelayPort;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableStompBrokerRelay("/topic/", "/queue/").setRelayHost(stompRelayHost).setRelayPort(stompRelayPort)
				.setUserRegistryBroadcast("/topic/simp-user-registry")
				.setUserDestinationBroadcast("/topic/unresolved-user-destination");

		// registry.enableSimpleBroker("/topic/", "/queue/");
		registry.setUserDestinationPrefix("/user/");
		registry.setApplicationDestinationPrefixes("/app/");

	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/gs-guide-websocket").addInterceptors(new HttpSessionHandshakeInterceptor())
				.setAllowedOrigins("*").withSockJS();
	}
}
