package main.validator.exercisevalidator.attributevalidators;

import main.model.Exercise;

public class ExerciseNameValidator implements IExerciseValidator {

    public static final int NAME_MAXIMUM_LENGTH = 30;
    public static final String NAME_ILLEGAL_CHARACTERS_REGEX = "^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$";

    @Override
    public String validate(Exercise exercise) {
        String attribute = exercise.getName();
        if (attribute.length() > NAME_MAXIMUM_LENGTH) {
            return "name is too long";
        } else if (!attribute.matches(NAME_ILLEGAL_CHARACTERS_REGEX)) {
            return "name contains illegal character";
        }
        return null;
    }
}
