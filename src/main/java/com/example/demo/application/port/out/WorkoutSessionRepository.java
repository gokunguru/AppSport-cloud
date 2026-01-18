package com.example.demo.application.port.out;

import com.example.demo.domain.model.WorkoutSession;

import java.util.List;
import java.util.Optional;

public interface WorkoutSessionRepository {
    WorkoutSession save(WorkoutSession session);
    Optional<WorkoutSession> findById(Long id);
    List<WorkoutSession> findAll(); 
}
