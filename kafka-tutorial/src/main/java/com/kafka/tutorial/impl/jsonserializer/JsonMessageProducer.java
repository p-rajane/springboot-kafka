package com.kafka.tutorial.impl.jsonserializer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageProducer {

	private KafkaTemplate<String, String> kafkaTemplate;
	
	public JsonMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	/**
	 * 
	 * @param message
	 */
	public void sendJsonMessage(Message<User> message) {
		kafkaTemplate.send(message);
	}
}
