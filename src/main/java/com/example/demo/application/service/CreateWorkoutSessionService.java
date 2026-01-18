package com.example.demo.application.service;

import com.example.demo.application.port.in.CreateWorkoutSessionUseCase;
import com.example.demo.application.port.out.WorkoutEventPublisher;
import com.example.demo.application.port.out.WorkoutSessionRepository;
import com.example.demo.domain.event.WorkoutCreatedEvent;
import com.example.demo.domain.model.WorkoutSession;
import org.springframework.stereotype.Service;

@Service
public class CreateWorkoutSessionService implements CreateWorkoutSessionUseCase {

    private final WorkoutSessionRepository repository;
    private final WorkoutEventPublisher publisher;

    public CreateWorkoutSessionService(WorkoutSessionRepository repository, WorkoutEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public WorkoutSession create(Long userId, int durationMinutes, int calories) {
        WorkoutSession created = new WorkoutSession(null, userId, durationMinutes, calories);
        WorkoutSession saved = repository.save(created);

        // Kafka obligatoire
        publisher.publish(new WorkoutCreatedEvent(saved.getId(), saved.getUserId(), saved.getCalories()));

        return saved;
    }
}
