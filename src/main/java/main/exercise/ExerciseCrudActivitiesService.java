package main.exercise;

import lombok.NonNull;
import main.exercisemessages.UserMessageRepository;
import main.model.Exercise;
import main.model.user.User;
import main.model.user.UserMessage;
import main.user.UserRepository;
import main.validator.attributes.exercise.ExerciseValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseCrudActivitiesService {

    private final ExerciseRepository exerciseRepository;

    private final UserMessageRepository userMessageRepository;

    private final UserRepository userRepository;

    private final ExerciseValidator exerciseValidator;

    private final String EXERCISE_MESSAGE = "You got this message, because you have %s marked as favourite and it was %s added to list of exercises for this bodypart.";

    public ExerciseCrudActivitiesService(ExerciseRepository exerciseRepository,
                                         UserMessageRepository userMessageRepository,
                                         UserRepository userRepository,
                                         ExerciseValidator exerciseValidator) {
        this.exerciseRepository = exerciseRepository;
        this.userMessageRepository = userMessageRepository;
        this.userRepository = userRepository;
        this.exerciseValidator = exerciseValidator;
    }

    public List<BodyPartType> getExerciseTypes() {
        return Arrays.asList(BodyPartType.values());
    }

    public List<Exercise> getExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercises::add);
        return exercises;
    }

    public List<Exercise> getExercisesForType(BodyPartType bodyPartType) {
        return exerciseRepository.getAllByBodyPartType(bodyPartType);
    }

    public List<String> addExercise(Exercise exercise) {
        List<String> messages = exerciseValidator.validate(exercise);
        if (CollectionUtils.isEmpty(messages)) {
            exerciseRepository.save(exercise);
            List<User> users = userRepository.findUsersByFavouriteBodyPartType(exercise.getBodyPartType());
            createAndSaveUserMessages(users, exercise.getName(), exercise.getBodyPartType());
        }
        return messages;
    }

    private void createAndSaveUserMessages(List<User> users, @NonNull String exerciseName, @NonNull BodyPartType bodyPartType) {
        users.stream().map(user -> UserMessage.builder()
                .creationTime(LocalDate.now())
                .userId(user.getId())
                .isAcknowledged(false)
                .message(String.format(EXERCISE_MESSAGE, bodyPartType, exerciseName))
                .build()).forEach(userMessageRepository::save);
    }
}