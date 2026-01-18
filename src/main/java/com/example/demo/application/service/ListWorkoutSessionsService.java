package com.example.demo.application.service;

import com.example.demo.application.port.in.ListWorkoutSessionsUseCase;
import com.example.demo.application.port.out.WorkoutSessionRepository;
import com.example.demo.domain.model.WorkoutSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListWorkoutSessionsService implements ListWorkoutSessionsUseCase {

    private final WorkoutSessionRepository repository;

    public ListWorkoutSessionsService(WorkoutSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WorkoutSession> listAll() {
        return repository.findAll();
    }
}