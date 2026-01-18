package com.example.demo.application.port.in;

import com.example.demo.domain.model.WorkoutSession;

public interface CreateWorkoutSessionUseCase {
    WorkoutSession create(Long userId, int durationMinutes, int calories);
}
