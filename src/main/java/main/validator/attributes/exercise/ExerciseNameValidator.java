package main.validator.attributes.exercise;

import main.model.Exercise;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_EXERCISE_NAME_MESSAGE;

@Component
public class ExerciseNameValidator implements Validator<Exercise> {

    @Override
    public String validate(Exercise exercise) {
        String attribute = exercise.getName();
        return attribute.isEmpty() ? EMPTY_EXERCISE_NAME_MESSAGE : null;
    }
}
