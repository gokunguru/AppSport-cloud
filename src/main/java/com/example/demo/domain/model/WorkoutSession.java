package com.example.demo.domain.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSession {

    private Long id;
    private Long userId;
    private int durationMinutes;
    private int calories;
    private final List<WorkoutSet> sets = new ArrayList<>();

    public WorkoutSession() {}

    public WorkoutSession(Long id, Long userId, int durationMinutes, int calories) {
        this.id = id;
        this.userId = userId;
        this.durationMinutes = durationMinutes;
        this.calories = calories;
    }

    public void addSet(WorkoutSet set) {
        this.sets.add(set);
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public int getDurationMinutes() { return durationMinutes; }
    public int getCalories() { return calories; }
    public List<WorkoutSet> getSets() { return sets; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setCalories(int calories) { this.calories = calories; }
}
