package main.configuration;

import main.exercise.ExerciseType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseTypeConverter implements Converter<String, ExerciseType> {

    @Override
    public ExerciseType convert(String exerciseTypeName) {
        return ExerciseType.forName(exerciseTypeName);
    }
}
