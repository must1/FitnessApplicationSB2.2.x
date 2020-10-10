package main.exercise;

import java.util.InputMismatchException;

public enum BodyPartType {
    CHEST, LEGS, BICEPS;

    private static final BodyPartType[] copyOfValues = values();

    public static BodyPartType forName(String name) {
        for (BodyPartType value : copyOfValues) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        throw new InputMismatchException("Given exercise does not exist!");
    }
}
