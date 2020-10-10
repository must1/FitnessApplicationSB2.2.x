package main.exercise;

import main.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

    List<Exercise> getAllByBodyPartType(BodyPartType bodyPartType);

}
