package com.example.demo.infrastructure.persistence.h2.adapter;

import com.example.demo.application.port.out.WorkoutSessionRepository;
import com.example.demo.domain.model.WorkoutSession;
import com.example.demo.domain.model.WorkoutSet;
import com.example.demo.infrastructure.persistence.h2.entity.WorkoutSessionEntity;
import com.example.demo.infrastructure.persistence.h2.entity.WorkoutSetEntity;
import com.example.demo.infrastructure.persistence.h2.jpa.JpaWorkoutSessionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class WorkoutSessionRepositoryH2Adapter implements WorkoutSessionRepository {

    private final JpaWorkoutSessionRepository jpa;

    public WorkoutSessionRepositoryH2Adapter(JpaWorkoutSessionRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public WorkoutSession save(WorkoutSession session) {
        WorkoutSessionEntity entity = toEntity(session);
        WorkoutSessionEntity saved = jpa.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<WorkoutSession> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }
    @Override
public List<WorkoutSession> findAll() {
    return jpa.findAll()
            .stream()
            .map(this::toDomain)
            .toList();
}

    /* =======================
       Mapping DOMAIN -> JPA
       ======================= */
    private WorkoutSessionEntity toEntity(WorkoutSession s) {
        WorkoutSessionEntity e = new WorkoutSessionEntity();
        e.setId(s.getId());
        e.setUserId(s.getUserId());
        e.setDurationMinutes(s.getDurationMinutes());
        e.setCalories(s.getCalories());

        e.getSets().clear();
        for (WorkoutSet set : s.getSets()) {
            WorkoutSetEntity se = new WorkoutSetEntity();
            se.setExercise(set.getExercise());
            se.setReps(set.getReps());
            se.setWeight(set.getWeight());
            se.setSession(e);
            e.getSets().add(se);
        }
        return e;
    }

    /* =======================
       Mapping JPA -> DOMAIN
       ======================= */
    private WorkoutSession toDomain(WorkoutSessionEntity e) {
        WorkoutSession s =
                new WorkoutSession(
                        e.getId(),
                        e.getUserId(),
                        e.getDurationMinutes(),
                        e.getCalories()
                );

        for (WorkoutSetEntity se : e.getSets()) {
            s.addSet(new WorkoutSet(
                    se.getExercise(),
                    se.getReps(),
                    se.getWeight()
            ));
        }
        return s;
    }
}
