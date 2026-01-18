package com.example.demo.application.port.out;

import com.example.demo.domain.event.WorkoutCreatedEvent;

public interface WorkoutEventPublisher {
    void publish(WorkoutCreatedEvent event);
}
