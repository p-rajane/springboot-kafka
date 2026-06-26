package com.kafka.tutorial.service.stringserializer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringMessageProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public StringMessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send("order", message);
	}
}
