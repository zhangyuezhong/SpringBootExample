package com.springboot.sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sse.web.context.SseEmitterManager;
import com.springboot.sse.web.context.UserSseEmitter;

@RestController
@RequestMapping("/api/callevents")
public class CallEventController {

	@Autowired
	private SseEmitterManager sseEmitterManager;

	@GetMapping("/{agentId}/{eventSourceId}")
	private UserSseEmitter get(@PathVariable String agentId, @PathVariable String eventSourceId) {
		UserSseEmitter emitter = new UserSseEmitter(Long.MAX_VALUE);
		emitter.setAgentId(agentId);
		emitter.setEventSourceId(eventSourceId);
		sseEmitterManager.add(emitter);
		return emitter;
	}
}