package com.kalifa.kalifa_jms_rest.producer.jms;

import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerJms {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	@JmsListener(destination = "${destination.queue}")
	public void receive(String message) {
		
	  LOGGER.info("received message='{}'", message);
	  LOGGER.info("########################");
	}
}
