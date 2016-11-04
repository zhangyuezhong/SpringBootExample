package com.telstra.springboot.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.telstra.springboot.jms.JmsClient;

@Component
public class ScheduledTasks {

	private AtomicInteger i = new AtomicInteger();
	@Autowired
	JmsClient jsmClient;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 2000)
	public void timeReport() {
		String msg = i.incrementAndGet() + " [TimeReport] Now: " + dateFormat.format(new Date());
		// System.out.println("----> " + msg);
		jsmClient.send(msg);
	}

	//@Scheduled(initialDelay = 1000, fixedRate = 2000)
	public void initDelayTimeReport() {
		// String msg = "[InitDelayTimeReport] Now: " + dateFormat.format(new
		// Date());
		// System.out.println("----> " + msg);
		// jsmClient.send(msg);
		//

		//String msg = jsmClient.receive();
		//System.out.println("----> " + msg);

	}

	//@Scheduled(cron = "*/5 * * * * *")
	public void cronTimeReport() {
		// String msg = "[CronTimeReport] Now: " + dateFormat.format(new
		// Date());
		// System.out.println("----> " + msg);
		// jsmClient.send(msg);
	}

}