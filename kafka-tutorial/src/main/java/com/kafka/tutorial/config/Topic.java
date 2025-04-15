package com.kafka.tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Topic {

	@Bean
	public NewTopic createNewTopic() {
		return TopicBuilder.name("spring-boot-demo")
				.build();
	}
}
