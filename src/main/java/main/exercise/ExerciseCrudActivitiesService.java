package main.exercise;

import main.model.Exercise;
import main.validator.exercisevalidator.attributevalidators.ExerciseValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseCrudActivitiesService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseCrudActivitiesService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<BodyPartType> getExerciseTypes() {
        return Arrays.asList(BodyPartType.values());
    }

    public List<Exercise> getExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercises::add);
        return exercises;
    }

    public List<Exercise> getExercisesForType(BodyPartType bodyPartType) {
        return exerciseRepository.getAllByBodyPartType(bodyPartType);
    }

    public List<String> addExercise(Exercise exercise) {
        List<String> messages = new ExerciseValidator().validate(exercise);
        if (CollectionUtils.isEmpty(messages)) {
            exerciseRepository.save(exercise);
        }
        return messages;
    }
}
