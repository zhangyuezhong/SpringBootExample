package com.springboot.sse.web.context;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class UserSseEmitter extends SseEmitter {

	private String agentId;
	private String eventSourceId;

	public UserSseEmitter() {
		super();
	}

	public UserSseEmitter(long timeout) {
		super(timeout);
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getEventSourceId() {
		return eventSourceId;
	}

	public void setEventSourceId(String eventSourceId) {
		this.eventSourceId = eventSourceId;
	}

	@Override
	public String toString() {
		return this.agentId + "_" + this.eventSourceId;
	}

	@Override
	protected void extendResponse(ServerHttpResponse outputMessage) {
		super.extendResponse(outputMessage);
		HttpHeaders headers = outputMessage.getHeaders();
		headers.setAccessControlAllowCredentials(true);
		headers.setAccessControlAllowOrigin("*");
		List<HttpMethod> m = new ArrayList<>();
		m.add(HttpMethod.GET);
		m.add(HttpMethod.POST);
		m.add(HttpMethod.OPTIONS);
		headers.setAccessControlAllowMethods(m);
		headers.setAccessControlMaxAge(1800);
		System.out.println("set header");
	}
}
