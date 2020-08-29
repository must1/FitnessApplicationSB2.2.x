package main.entity;

import lombok.*;
import main.exercise.ExerciseType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
public class Exercise {

    @Id
    @GeneratedValue
    private int id;
    @NonNull
    @Size(min = 3, max = 30, message = "username length should be between 3 and 30 chars")
    @Pattern(regexp = "^[A-Za-z0-9]+", message = "username contains illegal characters")
    private String name;
    @NonNull
    private ExerciseType exerciseType;
    private double caloriesBurned;
    @Size(max = 255, message = "maximum length of description is 255 characters")
    private String exerciseDescription;
}
