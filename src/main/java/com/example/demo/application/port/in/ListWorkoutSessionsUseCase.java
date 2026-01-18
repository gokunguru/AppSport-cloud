package com.example.demo.application.port.in;

import com.example.demo.domain.model.WorkoutSession;
import java.util.List;

public interface ListWorkoutSessionsUseCase {
    List<WorkoutSession> listAll();
}