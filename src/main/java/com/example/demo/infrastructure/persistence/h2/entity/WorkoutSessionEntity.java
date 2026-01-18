package com.example.demo.infrastructure.persistence.h2.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_sessions")
public class WorkoutSessionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int durationMinutes;
    private int calories;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WorkoutSetEntity> sets = new ArrayList<>();

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public int getDurationMinutes() { return durationMinutes; }
    public int getCalories() { return calories; }
    public List<WorkoutSetEntity> getSets() { return sets; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setCalories(int calories) { this.calories = calories; }
}
