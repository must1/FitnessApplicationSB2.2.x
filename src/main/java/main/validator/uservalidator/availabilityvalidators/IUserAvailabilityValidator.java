package main.validator.uservalidator.availabilityvalidators;

import main.model.user.User;
import main.user.UserRepository;

public interface IUserAvailabilityValidator {

    String validate(User user, UserRepository userRepository);
}
