package com.example.demo.infrastructure.persistence.h2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_sets")
public class WorkoutSetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exercise;
    private int reps;
    private double weight;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private WorkoutSessionEntity session;

    public Long getId() { return id; }
    public String getExercise() { return exercise; }
    public int getReps() { return reps; }
    public double getWeight() { return weight; }
    public WorkoutSessionEntity getSession() { return session; }

    public void setId(Long id) { this.id = id; }
    public void setExercise(String exercise) { this.exercise = exercise; }
    public void setReps(int reps) { this.reps = reps; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setSession(WorkoutSessionEntity session) { this.session = session; }
}
