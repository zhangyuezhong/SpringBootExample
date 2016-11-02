package com.telstra.springboot.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.springboot.domain.Greeting;
import com.telstra.springboot.domain.Message;

@RestController
public class ChatController {

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public Message send(Message message) throws Exception {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		message.setName(time + " " + message.getName());
		return message;
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

	// @SubscribeMapping("/user/queue/reply")
	// public void init() {
	// System.out.println("@SubscribeMapping");
	// }
	@RequestMapping(value = "/greetings", method = RequestMethod.POST)
	public Message greet(@RequestBody Message message, Principal p) {
		String text = "[" + System.currentTimeMillis() + "]:" + message.getName();
		Greeting greeting = new Greeting(text);
		// this.template.convertAndSend("/topic/greetings", greeting);
		System.out.println("name=" + p.getName());

		String user = p.getName();
		String msg = message.getName();
		Greeting greeting1 = new Greeting("Greeting to " + user + " msg=" + msg + "  " + System.currentTimeMillis());
		if (message.getName().contains(":")) {
			String[] parts = message.getName().split(":");
			user = parts[0];
			msg = parts[1];
			greeting1 = new Greeting("Greeting to " + user + " msg=" + msg + "  " + System.currentTimeMillis());
			this.template.convertAndSendToUser(user, "/queue/reply", greeting1);
		} else {
			this.template.convertAndSendToUser(p.getName(), "/queue/reply", greeting1);
		}
		Message m = new Message();
		m.setName("send completed");
		return m;
	}
}
