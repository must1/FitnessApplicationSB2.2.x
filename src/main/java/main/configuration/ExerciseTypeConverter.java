package main.configuration;

import main.exercise.BodyPartType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseTypeConverter implements Converter<String, BodyPartType> {

    @Override
    public BodyPartType convert(String exerciseTypeName) {
        return BodyPartType.forName(exerciseTypeName);
    }
}
