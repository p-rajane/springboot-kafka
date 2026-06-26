package com.kafka.tutorial.service.jsonserializer;

import com.kafka.tutorial.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageConsumer {
	
	@KafkaListener(topics = "spring-boot-demo", groupId = "myGroup")
	public void consumeMessage(User user) {
		System.out.print("\nReceived message by listener ==> " + user.getName() + " " + user.getSurname());
		
	}

}
