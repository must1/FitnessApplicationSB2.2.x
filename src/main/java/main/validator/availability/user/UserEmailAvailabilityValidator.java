package main.validator.availability.user;

import main.model.user.User;
import main.user.UserRepository;
import main.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static main.validator.ErrorConstants.NOT_AVAILABLE_EMAIL_MESSAGE;

@Component
public class UserEmailAvailabilityValidator implements AvailabilityValidator<User> {

    private final UserRepository userRepository;

    public UserEmailAvailabilityValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String validate(User value) {
        Optional<User> email = userRepository.findByEmail(value.getEmail());
        return email.map(a -> NOT_AVAILABLE_EMAIL_MESSAGE).orElse(null);
    }
}
