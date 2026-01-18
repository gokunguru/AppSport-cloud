package com.example.demo.application.service;

import com.example.demo.application.port.in.WorkoutEventConsumerUseCase;
import com.example.demo.domain.event.WorkoutCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkoutEventConsumerService implements WorkoutEventConsumerUseCase {

    private static final Logger log =
            LoggerFactory.getLogger(WorkoutEventConsumerService.class);

    @Override
    public void handleWorkoutCreated(WorkoutCreatedEvent event) {
        // LOG 
        log.info(
            "[KAFKA CONSUMER] Workout session received | sessionId={} userId={} calories={}",
            event.workoutId(),
            event.userId(),
            event.calories()
        );
    }
}