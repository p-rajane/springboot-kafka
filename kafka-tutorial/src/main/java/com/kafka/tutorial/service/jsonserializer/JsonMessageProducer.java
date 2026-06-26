package com.kafka.tutorial.service.jsonserializer;

import com.kafka.tutorial.dto.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public JsonMessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
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
