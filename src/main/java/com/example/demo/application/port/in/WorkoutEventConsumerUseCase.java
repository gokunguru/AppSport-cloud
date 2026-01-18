package com.example.demo.application.port.in;

import com.example.demo.domain.event.WorkoutCreatedEvent;

public interface WorkoutEventConsumerUseCase {
    void handleWorkoutCreated(WorkoutCreatedEvent event);
}