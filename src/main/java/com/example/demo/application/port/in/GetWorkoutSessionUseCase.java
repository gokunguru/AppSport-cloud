package com.example.demo.application.port.in;

import com.example.demo.domain.model.WorkoutSession;

public interface GetWorkoutSessionUseCase {
    WorkoutSession getById(Long id);
}