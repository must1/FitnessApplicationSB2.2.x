package main.exercise;

import main.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, UUID> {

    List<Exercise> getAllByBodyPartType(BodyPartType bodyPartType);

}
