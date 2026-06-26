package com.kafka.tutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

/**
 * @author Pramod Rajane
 */

@Slf4j
@Service
public class ErrorProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ErrorProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RetryableTopic(
            attempts = "3",
            backoff = @Backoff(delay = 2000, multiplier = 3),
            dltTopicSuffix = "-dlt",
            autoCreateTopics = "true"
    )
    @KafkaListener(topics = "order", groupId = "myGroup")
    public void sendErrorMessage(String message) {
        throw new RuntimeException("Error occurred while sending message: " + message);
    }

    @DltHandler
    public void sendErrorMessageToKafka(String message) {
        log.info("Received message in DLT topic:  {}", message);
    }
}
