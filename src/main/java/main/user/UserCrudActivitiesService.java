package main.user;

import main.model.User;
import main.validator.uservalidator.attributesvalidator.UserAttributesValidator;
import main.validator.uservalidator.availabilityvalidators.UserAvailabilityValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserCrudActivitiesService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCrudActivitiesService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
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
        UserAttributesValidator userAttributesValidator = new UserAttributesValidator();
        UserAvailabilityValidator userAvailabilityValidator = new UserAvailabilityValidator(userRepository);

        List<String> attributesErrors = userAttributesValidator.validate(user);
        List<String> availabilityErrors = userAvailabilityValidator.validate(user);

        return Stream.concat(attributesErrors.stream(), availabilityErrors.stream())
                .collect(Collectors.toList());
    }
}
