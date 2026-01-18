package com.example.demo.application.port.in;

import com.example.demo.domain.model.WorkoutSession;

public interface AddSetToSessionUseCase {
    WorkoutSession addSet(Long sessionId, String exercise, int reps, double weight);
}
