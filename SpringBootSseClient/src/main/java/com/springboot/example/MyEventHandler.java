package com.springboot.example;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.xlightweb.Event;
import org.xlightweb.IEventDataSource;
import org.xlightweb.IEventHandler;

@Component
public class MyEventHandler implements IEventHandler {

	public void onConnect(IEventDataSource webEventDataSource) throws IOException {
		System.out.println("Connected");
	}

	public void onMessage(IEventDataSource webEventDataSource) throws IOException {
		Event event = webEventDataSource.readMessage();
		System.out.println("event=" + event.getData());

	}

	public void onDisconnect(IEventDataSource webEventDataSource) throws IOException {
		System.out.println("onDisconnect");
	}
}
