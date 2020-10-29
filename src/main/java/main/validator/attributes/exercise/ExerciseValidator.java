package main.validator.attributes.exercise;

import main.model.Exercise;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ExerciseValidator {

    private final List<Validator<Exercise>> validators;

    public ExerciseValidator(List<Validator<Exercise>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Exercise exercise) {
        return validators.stream()
                .map(e -> e.validate(exercise))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
