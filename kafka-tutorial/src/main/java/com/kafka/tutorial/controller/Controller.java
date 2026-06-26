package com.kafka.tutorial.controller;

import com.kafka.tutorial.dto.User;
import com.kafka.tutorial.service.ErrorProducer;
import com.kafka.tutorial.service.jsonserializer.JsonMessageProducer;
import com.kafka.tutorial.service.stringserializer.StringMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

	private final StringMessageProducer stringMessageProducer;
	private final JsonMessageProducer jsonMessageProducer;
    private final ErrorProducer errorProducer;

	public Controller(StringMessageProducer messageProducer, JsonMessageProducer jsonMessageProducer, ErrorProducer errorProducer) {
		this.stringMessageProducer = messageProducer;
		this.jsonMessageProducer = jsonMessageProducer;
        this.errorProducer = errorProducer;
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
