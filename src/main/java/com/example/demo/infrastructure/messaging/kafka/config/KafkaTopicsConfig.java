package com.example.demo.infrastructure.messaging.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic workoutCreatedTopic() {
        return TopicBuilder.name("workout.created")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
