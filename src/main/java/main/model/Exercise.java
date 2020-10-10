package main.model;

import lombok.*;
import main.exercise.BodyPartType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String name;
    @NonNull
    private BodyPartType bodyPartType;
    private double caloriesBurned;
    private String exerciseDescription;
}
