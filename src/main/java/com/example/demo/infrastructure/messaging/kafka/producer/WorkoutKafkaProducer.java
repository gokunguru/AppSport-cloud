package com.example.demo.infrastructure.messaging.kafka.producer;

import com.example.demo.application.port.out.WorkoutEventPublisher;
import com.example.demo.domain.event.WorkoutCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class WorkoutKafkaProducer implements WorkoutEventPublisher {

    private static final String TOPIC = "workout.created";

    private final KafkaTemplate<String, WorkoutCreatedEvent> kafkaTemplate;

    public WorkoutKafkaProducer(KafkaTemplate<String, WorkoutCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(WorkoutCreatedEvent event) {
       
        kafkaTemplate.send(TOPIC, event.workoutId().toString(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        System.err.println(" Kafka publish failed: " + ex.getMessage());
                    } else {
                        System.out.println(" Published to " + TOPIC + " key=" + event.workoutId());
                    }
                });
    }
}
