package main.user;

import main.model.user.User;
import main.validator.attributes.user.UserAttributesValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import main.validator.availability.user.UserAvailabilityValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserCrudActivitiesService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAvailabilityValidator userAvailabilityValidator;
    private final UserAttributesValidator userAttributesValidator;

    public UserCrudActivitiesService(UserRepository userRepository, UserAvailabilityValidator userAvailabilityValidator, UserAttributesValidator userAttributesValidator) {
        this.userRepository = userRepository;
        this.userAttributesValidator = userAttributesValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userAvailabilityValidator = userAvailabilityValidator;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<String> createUser(User user) {
        List<String> messages = validateUser(user);

        if (CollectionUtils.isEmpty(messages)) {
            userRepository.save(user.toBuilder()
                    .password(passwordEncoder.encode(user.getPassword()))
                    .build());
        }
        return messages;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    private List<String> validateUser(User user) {
        List<String> attributesErrors = userAttributesValidator.validate(user);
        List<String> availabilityErrors = userAvailabilityValidator.validate(user);

        return Stream.concat(attributesErrors.stream(), availabilityErrors.stream())
                .collect(Collectors.toList());
    }
}
