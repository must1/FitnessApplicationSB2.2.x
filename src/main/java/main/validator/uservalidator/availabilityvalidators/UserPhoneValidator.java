package main.validator.uservalidator.availabilityvalidators;

import main.model.User;
import main.user.UserRepository;

import java.util.Optional;

public class UserPhoneValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        Optional<User> phoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());
        return phoneNumber.map(value -> "User with given phone number already exists").orElse(null);
    }
}
