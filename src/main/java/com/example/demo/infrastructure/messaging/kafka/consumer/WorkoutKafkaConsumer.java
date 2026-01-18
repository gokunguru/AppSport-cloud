package com.example.demo.infrastructure.kafka;

import com.example.demo.application.port.in.WorkoutEventConsumerUseCase;
import com.example.demo.domain.event.WorkoutCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WorkoutKafkaConsumer {

    private final WorkoutEventConsumerUseCase useCase;

    public WorkoutKafkaConsumer(WorkoutEventConsumerUseCase useCase) {
        this.useCase = useCase;
    }

    @KafkaListener(
        topics = "workout.created",
        groupId = "appsport-group"
    )
    public void listen(WorkoutCreatedEvent event) {
        useCase.handleWorkoutCreated(event);
    }
}