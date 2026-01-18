package com.example.demo.domain.event;

public record WorkoutCreatedEvent(Long workoutId, Long userId, int calories) {}
