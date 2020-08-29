package main.exercise;

import java.util.InputMismatchException;

public enum ExerciseType {
    CARDIO, WEIGHTLIFTING;

    private static final ExerciseType[] copyOfValues = values();

    public static ExerciseType forName(String name) {
        for (ExerciseType value : copyOfValues) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        throw new InputMismatchException("Given exercise does not exist!");
    }
}
