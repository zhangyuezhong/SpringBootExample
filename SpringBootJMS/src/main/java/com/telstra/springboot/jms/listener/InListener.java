package com.telstra.springboot.jms.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InListener {

	@Value("${jms.queue.destination}")
	String destinationQueue;

	@JmsListener(destination = "DEMO-JMS-QUEUE")
	public void receiveOrder(String msg) {
		System.out.println("inListenr-> " + msg);
	}
}