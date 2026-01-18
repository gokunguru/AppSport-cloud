package com.example.demo.adapters.rest;

import com.example.demo.adapters.rest.dto.AddSetRequest;
import com.example.demo.adapters.rest.dto.CreateWorkoutSessionRequest;
import com.example.demo.adapters.rest.dto.WorkoutSessionResponse;
import com.example.demo.application.port.in.AddSetToSessionUseCase;
import com.example.demo.application.port.in.CreateWorkoutSessionUseCase;
import com.example.demo.application.port.in.GetWorkoutSessionUseCase;
import com.example.demo.application.port.in.ListWorkoutSessionsUseCase;
import com.example.demo.domain.model.WorkoutSession;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class WorkoutSessionController {

    private final CreateWorkoutSessionUseCase createUseCase;
    private final AddSetToSessionUseCase addSetUseCase;
    private final GetWorkoutSessionUseCase getUseCase;
    private final ListWorkoutSessionsUseCase listUseCase;

   public WorkoutSessionController(
        CreateWorkoutSessionUseCase createUseCase,
        AddSetToSessionUseCase addSetUseCase,
        GetWorkoutSessionUseCase getUseCase,
        ListWorkoutSessionsUseCase listUseCase
) {
    this.createUseCase = createUseCase;
    this.addSetUseCase = addSetUseCase;
    this.getUseCase = getUseCase;
    this.listUseCase = listUseCase;
}

    @PostMapping
    public WorkoutSessionResponse create(@RequestBody CreateWorkoutSessionRequest req) {
        WorkoutSession s = createUseCase.create(req.userId(), req.durationMinutes(), req.calories());
        return map(s);
    }

    @PostMapping("/{id}/sets")
    public WorkoutSessionResponse addSet(@PathVariable Long id, @RequestBody AddSetRequest req) {
        WorkoutSession s = addSetUseCase.addSet(id, req.exercise(), req.reps(), req.weight());
        return map(s);
    }

    private WorkoutSessionResponse map(WorkoutSession s) {
        var sets = s.getSets().stream()
                .map(x -> new WorkoutSessionResponse.SetResponse(x.getExercise(), x.getReps(), x.getWeight()))
                .toList();
        return new WorkoutSessionResponse(s.getId(), s.getUserId(), s.getDurationMinutes(), s.getCalories(), sets);
    }

    @GetMapping("/{id}")
public WorkoutSessionResponse getById(@PathVariable Long id) {
    WorkoutSession s = getUseCase.getById(id);
    return map(s);
}

    @GetMapping
public List<WorkoutSessionResponse> listAll() {
    return listUseCase.listAll()
            .stream()
            .map(this::map)
            .toList();
}
}
