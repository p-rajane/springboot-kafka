package com.kafka.tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.tutorial.impl.jsonserializer.JsonMessageProducer;
import com.kafka.tutorial.impl.jsonserializer.User;
import com.kafka.tutorial.impl.stringserializer.StringMessageProducer;

@RestController
@RequestMapping("/api")
public class Controller {

	private StringMessageProducer stringMessageProducer;
	private JsonMessageProducer jsonMessageProducer;
	
	public Controller(StringMessageProducer messageProducer, JsonMessageProducer jsonMessageProducer) {
		this.stringMessageProducer = messageProducer;
		this.jsonMessageProducer = jsonMessageProducer;
	}
	
	//localhost:8080/api/publishString?message=Hi Pramod, welcome to Spring Boot application.
	@GetMapping("/publishString")
	public ResponseEntity<String> publishMessage (@RequestParam("message") String message) {
		stringMessageProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent...");
	}
	
	//localhost:8080/api/publishString?message=Hi Pramod, welcome to Spring Boot application.
	@PostMapping("/publishJson")
	public ResponseEntity<String> publishMessage (@RequestBody User user) {
		Message<User> message = MessageBuilder.withPayload(user)
		.setHeader(KafkaHeaders.TOPIC, "spring-boot-demo")
		.build();
		jsonMessageProducer.sendJsonMessage(message);
		return ResponseEntity.ok("Message sent...");
	}
}
