package com.springboot.sse.web.context;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitterManager {
	private static final Logger logger = LoggerFactory.getLogger(SseEmitterManager.class);
	private Queue<UserSseEmitter> emitters = new ConcurrentLinkedQueue<UserSseEmitter>();
	@Async
	public void add(UserSseEmitter e) {
		try {
			// It is required to send 2 KB padding for IE < 10
			// (XDomainRequest) and Chrome <
			// 13 at the top of the response stream
			SseEmitter.SseEventBuilder heartbeat = SseEmitter.event();
			char[] chars = new char[2056];
			Arrays.fill(chars, 'a');
			heartbeat.comment(new String(chars));
			heartbeat.reconnectTime(1000L);
			e.send(heartbeat);
			emitters.add(e);
			logger.debug("added UserSseEmitter {} ", e);
		} catch (Exception ex) {
			// the browser is already closed, or logout
			logger.error("added UserSseEmitter {}  {}", e, ex.getMessage());
		}
	}

	@Async
	public void remove(UserSseEmitter e) {
		emitters.remove(e);
	}

	@Async
	public void sendCallEvent(CallEvent event) {
		if (emitters.isEmpty()) {
			logger.debug("sendCallEvent emitters is empty");
			return;
		}

		SseEmitter.SseEventBuilder builder = SseEmitter.event();
		builder.id(String.valueOf(System.currentTimeMillis()));
		builder.name("data");
		builder.data(event, MediaType.APPLICATION_JSON);
		builder.reconnectTime(1000L);
		SseEvent evt = new SseEvent(builder);
		emitters.removeIf((emitter) -> {
			try {
				emitter.send(evt);
				logger.debug("sendCallEvent emitter {} CallEvent {}", emitter, event);
				return false;
			} catch (Exception e) {
				logger.error("sendCallEvent emitter {}  {}", emitter, e.getMessage());
				return true;
			}
		});

	}

	@Async
	public void sendHeartbeat() {
		if (emitters.isEmpty()) {
			logger.debug("sendHeartbeat emitters is empty");
			return;
		}
		AtomicInteger counter = new AtomicInteger();
		long startTime = System.currentTimeMillis();
		SseEmitter.SseEventBuilder builder = SseEmitter.event();
		builder.comment("heartbeat");
		builder.reconnectTime(1000L);
		SseEvent evt = new SseEvent(builder);
		emitters.removeIf((emitter) -> {
			try {
				emitter.send(evt);
				counter.getAndIncrement();
				return false;
			} catch (Exception e) {
				logger.error("sendHeartbeat emitter {}  {}", emitter, e.getMessage());
				return true;
			}
		});
		long endTime = System.currentTimeMillis();
		logger.debug("sendHeartbeat to {} emitters in {} milliseconds", counter.intValue(), (endTime - startTime));
	}

	@Async
	public void sendCompleted() {
		emitters.removeIf((emitter) -> {
			try {
				emitter.complete();
				logger.debug("sendCompleted emitter {} ", emitter);
				return true;
			} catch (Exception e) {
				logger.error("sendCompleted emitter {}  {}", emitter, e.getMessage());
			}
			return false;
		});
	}
}
