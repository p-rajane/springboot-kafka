package com.kafka.tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic createNewTopic() {
        return new NewTopic("spring-boot-demo", 1, (short) 1);
	}
}
