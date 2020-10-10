package main.validator.uservalidator.availabilityvalidators;

import main.model.user.User;
import main.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserAvailabilityValidator {

    private final  List<IUserAvailabilityValidator> validators;

    private final UserRepository userRepository;

    public UserAvailabilityValidator(UserRepository userRepository){
        this.userRepository = userRepository;
        validators = new ArrayList<>();
        validators.add(new UserEmailValidator());
        validators.add(new UsernameValidator());
        validators.add(new UserPhoneValidator());
    }

    public List<String> validate(User user){

        return validators.stream()
                .map(e -> e.validate(user, userRepository))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
