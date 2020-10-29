package main.validator.availability.user;

import main.model.user.User;
import main.user.UserRepository;
import main.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static main.validator.ErrorConstants.NOT_AVAILABLE_USERNAME_MESSAGE;

@Component
public class UsernameAvailabilityValidator implements AvailabilityValidator<User> {

    private final UserRepository userRepository;

    public UsernameAvailabilityValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String validate(User value) {
        Optional<User> username = userRepository.findByUsername(value.getUsername());
        return username.map(a -> NOT_AVAILABLE_USERNAME_MESSAGE).orElse(null);
    }
}
