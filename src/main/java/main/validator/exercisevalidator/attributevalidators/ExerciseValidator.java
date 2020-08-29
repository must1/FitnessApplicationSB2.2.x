package main.validator.exercisevalidator.attributevalidators;

import main.entity.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExerciseValidator {

    private final List<IExerciseValidator> validators;

    public ExerciseValidator() {
        validators = new ArrayList<>();
        validators.add(new ExerciseDescriptionValidator());
        validators.add(new ExerciseNameValidator());
    }

    public List<String> validate(Exercise exercise) {
        return validators.stream()
                .map(e -> e.validate(exercise))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
