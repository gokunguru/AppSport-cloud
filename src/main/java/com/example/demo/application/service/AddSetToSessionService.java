package com.example.demo.application.service;

import com.example.demo.application.port.in.AddSetToSessionUseCase;
import com.example.demo.application.port.out.WorkoutSessionRepository;
import com.example.demo.domain.model.WorkoutSet;
import com.example.demo.domain.model.WorkoutSession;
import org.springframework.stereotype.Service;

@Service
public class AddSetToSessionService implements AddSetToSessionUseCase {

    private final WorkoutSessionRepository repository;

    public AddSetToSessionService(WorkoutSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkoutSession addSet(Long sessionId, String exercise, int reps, double weight) {
        WorkoutSession session = repository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session not found: " + sessionId));

        session.addSet(new WorkoutSet(exercise, reps, weight));
        return repository.save(session);
    }
}

