package com.kalifa.kalifa_jms_rest;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import com.kalifa.kalifa_jms_rest.producer.jms.SenderJms;

//@Component
public class SpringJmsScheduled {

  @Autowired
  private SenderJms sender;

  @Value("${destination.queue}")
  private String destination;
  
  @Scheduled(initialDelay=1000, fixedRate=5000)
  public void sendMessage() throws JMSException {
		
		String json = "{\"name\":\"Maria\"}";
		
		sender.send(destination, json);
	}
}
