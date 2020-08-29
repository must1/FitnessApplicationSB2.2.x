package main.controller;

import main.entity.Exercise;
import main.exercise.ExerciseCrudActivitiesService;
import main.exercise.ExerciseType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseCrudActivitiesController {

    private final ExerciseCrudActivitiesService exerciseCrudActivitiesService;

    public ExerciseCrudActivitiesController(ExerciseCrudActivitiesService exerciseCrudActivitiesService) {
        this.exerciseCrudActivitiesService = exerciseCrudActivitiesService;
    }

    @GetMapping("/exercisetypes")
    public List<ExerciseType> getExerciseTypes() {
        return exerciseCrudActivitiesService.getExerciseTypes();
    }

    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseCrudActivitiesService.getExercises();
    }

    @GetMapping("/exercise")
    public List<Exercise> getExercisesForType(@RequestParam("type") ExerciseType exerciseType) {
        return exerciseCrudActivitiesService.getExercisesForType(exerciseType);
    }

    @PostMapping("/exercise")
    public List<String> addExercise(@RequestBody Exercise exercise) {
        return exerciseCrudActivitiesService.addExercise(exercise);
    }

}