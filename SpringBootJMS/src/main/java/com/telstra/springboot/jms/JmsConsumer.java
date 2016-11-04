package com.telstra.springboot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    @Autowired
    JmsTemplate jmsTemplate;
     
    @Value("${jms.queue.destination}")
    String destinationQueue;
     
    public String receive(){
        return (String)jmsTemplate.receiveAndConvert(destinationQueue); 
    }
}