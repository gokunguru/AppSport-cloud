package com.example.demo.application.service;

import com.example.demo.application.port.in.GetWorkoutSessionUseCase;
import com.example.demo.application.port.out.WorkoutSessionRepository;
import com.example.demo.domain.model.WorkoutSession;
import org.springframework.stereotype.Service;

@Service
public class GetWorkoutSessionService implements GetWorkoutSessionUseCase {

    private final WorkoutSessionRepository repository;

    public GetWorkoutSessionService(WorkoutSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkoutSession getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Workout session not found"));
    }
}