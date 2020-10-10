package main.validator.uservalidator.availabilityvalidators;

import main.model.user.User;
import main.user.UserRepository;

import java.util.Optional;

public class UsernameValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        Optional<User> username = userRepository.findByUsername(user.getUsername());
        return username.map(value -> "User with given username already exists").orElse(null);
    }
}
