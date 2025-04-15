package com.kafka.tutorial.impl.stringserializer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringMessageConsumer {
	
	@KafkaListener(topics = "spring-boot-demo", groupId = "myGroup")
	public void consumeMessage(String message) {
		System.out.print("\nReceived message by listener ==> " + message);
		
	}

}
