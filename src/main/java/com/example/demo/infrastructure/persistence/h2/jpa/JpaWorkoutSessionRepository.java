package com.example.demo.infrastructure.persistence.h2.jpa;

import com.example.demo.infrastructure.persistence.h2.entity.WorkoutSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWorkoutSessionRepository extends JpaRepository<WorkoutSessionEntity, Long> {}
