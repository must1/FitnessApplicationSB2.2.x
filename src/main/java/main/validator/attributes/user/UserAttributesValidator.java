package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserAttributesValidator {

    private final List<Validator<User>> validators;

    @Autowired
    public UserAttributesValidator(List<Validator<User>> validators) {
        this.validators = validators;
    }

    public List<String> validate(User user) {
        return validators.stream()
                .map(e -> e.validate(user))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
