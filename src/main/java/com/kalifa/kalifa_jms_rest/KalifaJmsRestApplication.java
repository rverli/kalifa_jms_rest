package com.kalifa.kalifa_jms_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class KalifaJmsRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KalifaJmsRestApplication.class, args);
	}
}
