package main.validator.exercisevalidator.attributevalidators;

import main.model.Exercise;

public class ExerciseDescriptionValidator implements IExerciseValidator {

    public static final String DESCRIPTION_ILLEGAL_CHARACTERS_REGEX = "^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$";
    public static final int DESCRIPTION_MAXIMUM_LENGTH = 255;

    @Override
    public String validate(Exercise exercise) {
        String attribute = exercise.getExerciseDescription();
        if (attribute.length() > DESCRIPTION_MAXIMUM_LENGTH) {
            return "description is too long";
        } else if (!attribute.matches(DESCRIPTION_ILLEGAL_CHARACTERS_REGEX)) {
            return "description contains illegal character";
        }
        return null;
    }
}
