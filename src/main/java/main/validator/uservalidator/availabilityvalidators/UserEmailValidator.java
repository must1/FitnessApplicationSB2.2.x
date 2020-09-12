package main.validator.uservalidator.availabilityvalidators;

import main.entity.User;
import main.user.UserRepository;

import java.util.Optional;

public class UserEmailValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        Optional<User> email = userRepository.findByEmail(user.getEmail());
        return email.map(value -> "User with given email already exists").orElse(null);
    }
}
