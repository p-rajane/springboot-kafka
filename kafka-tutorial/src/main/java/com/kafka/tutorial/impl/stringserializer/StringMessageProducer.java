package com.kafka.tutorial.impl.stringserializer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringMessageProducer {

	private KafkaTemplate<String, String> kafkaTemplate;
	
	public StringMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send("spring-boot-demo", message);
	}
}
