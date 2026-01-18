package com.example.demo.domain.model;

public class WorkoutSet {

    private String exercise;
    private int reps;
    private double weight;

    public WorkoutSet() {}

    public WorkoutSet(String exercise, int reps, double weight) {
        this.exercise = exercise;
        this.reps = reps;
        this.weight = weight;
    }

    public String getExercise() { return exercise; }
    public int getReps() { return reps; }
    public double getWeight() { return weight; }

    public void setExercise(String exercise) { this.exercise = exercise; }
    public void setReps(int reps) { this.reps = reps; }
    public void setWeight(double weight) { this.weight = weight; }
}
