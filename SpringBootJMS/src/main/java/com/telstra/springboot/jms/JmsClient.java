package com.telstra.springboot.jms;

public interface JmsClient {
    public void send(String msg);
    public String receive();
}
