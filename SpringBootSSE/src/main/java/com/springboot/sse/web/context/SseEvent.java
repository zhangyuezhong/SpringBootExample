package com.springboot.sse.web.context;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter.DataWithMediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

public class SseEvent implements SseEventBuilder {

	private Set<DataWithMediaType> dataToSend;

	public SseEvent(SseEventBuilder builder) {
		this.dataToSend = builder.build();
	}

	@Override
	public SseEventBuilder comment(String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SseEventBuilder name(String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SseEventBuilder id(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SseEventBuilder reconnectTime(long reconnectTimeMillis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SseEventBuilder data(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SseEventBuilder data(Object object, MediaType mediaType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DataWithMediaType> build() {
		return this.dataToSend;
	}
}
