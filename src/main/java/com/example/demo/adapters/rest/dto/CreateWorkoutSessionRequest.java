package com.example.demo.adapters.rest.dto;

public record CreateWorkoutSessionRequest(Long userId, int durationMinutes, int calories) {}
