package main.controller;

import main.model.Exercise;
import main.exercise.ExerciseCrudActivitiesService;
import main.exercise.BodyPartType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class   ExerciseCrudActivitiesController {

    private final ExerciseCrudActivitiesService exerciseCrudActivitiesService;

    public ExerciseCrudActivitiesController(ExerciseCrudActivitiesService exerciseCrudActivitiesService) {
        this.exerciseCrudActivitiesService = exerciseCrudActivitiesService;
    }

    @GetMapping("/exercisetypes")
    public List<BodyPartType> getExerciseTypes() {
        return exerciseCrudActivitiesService.getExerciseTypes();
    }

    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseCrudActivitiesService.getExercises();
    }

    @GetMapping("/exercise")
    public List<Exercise> getExercisesForType(@RequestParam("type") BodyPartType bodyPartType) {
        return exerciseCrudActivitiesService.getExercisesForType(bodyPartType);
    }

    @PostMapping("/createExercise")
    public List<String> addExercise(@RequestBody Exercise exercise) {
        return exerciseCrudActivitiesService.addExercise(exercise);
    }

}