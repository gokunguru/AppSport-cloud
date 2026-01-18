package com.example.demo.adapters.rest.dto;

import java.util.List;

public record WorkoutSessionResponse(
        Long id,
        Long userId,
        int durationMinutes,
        int calories,
        List<SetResponse> sets
) {
    public record SetResponse(String exercise, int reps, double weight) {}
}
