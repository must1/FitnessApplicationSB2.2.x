package main.validator.availability.user;

import main.model.user.User;
import main.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserAvailabilityValidator {

    private final List<AvailabilityValidator<User>> validators;

    public UserAvailabilityValidator(List<AvailabilityValidator<User>> validators) {
        this.validators = validators;
    }

    public List<String> validate(User user) {
        return validators.stream()
                .map(e -> e.validate(user))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
