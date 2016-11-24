package com.springboot.sse.web.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HeartbeatManager {

	@Autowired
	private SseEmitterManager sseEmitterManager;

	@Scheduled(initialDelay = 10000, fixedDelay = 180000)
	public void sendHeartBeat() {
		sseEmitterManager.sendHeartbeat();
	}

	@Scheduled(initialDelay = 15000, fixedDelay = 20000)
	public void sendCallEvent() {
		CallEvent c = new CallEvent();
		c.setAgentId("3993");
		c.setAgentNotes(RandomUtils.randomString(1024));
		c.setAgentTerminal("3333");
		c.setCalledNumber("04179748481");
		c.setCallId(RandomUtils.randomUniqueString(10));
		c.setCallingNumber("484848");
		c.setCallingTerminal("33333");
		c.setConnectionId("32839289283");
		c.setCustomerNumber("3232928208302");
		c.setEventType("CONNECT");
		c.setIvrData(RandomUtils.randomString(60));
		c.setIvrUCID(RandomUtils.randomString(12));
		c.setOldCallId("382832832");
		c.setOldUCID(RandomUtils.randomString(12));
		c.setQueueTime("32");
		c.setSapActivityId(RandomUtils.randomString(10));
		c.setTimestamp(String.valueOf(System.currentTimeMillis()));
		c.setUCID(RandomUtils.randomString(12));
		c.setUEC(RandomUtils.randomString(8));
		c.setUUI(RandomUtils.randomString(12));
		sseEmitterManager.sendCallEvent(c);
	}
}