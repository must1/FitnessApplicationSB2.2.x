package main.validator.availability.user;

import main.model.user.User;
import main.user.UserRepository;
import main.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static main.validator.ErrorConstants.NOT_AVAILABLE_PHONE_NUMBER_MESSAGE;

@Component
public class UserPhoneAvailabilityValidator implements AvailabilityValidator<User> {

    private final UserRepository userRepository;

    public UserPhoneAvailabilityValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String validate(User value) {
        Optional<User> phoneNumber = userRepository.findByPhoneNumber(value.getPhoneNumber());
        return phoneNumber.map(a -> NOT_AVAILABLE_PHONE_NUMBER_MESSAGE).orElse(null);
    }
}
