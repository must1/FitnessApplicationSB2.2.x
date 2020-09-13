package main.validator.uservalidator.attributesvalidator;

import main.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserAttributesValidator {

    private final List<IUserAttributesValidator> validators;

    public UserAttributesValidator() {
        validators = new ArrayList<>();
        validators.add(new UserEmailValidator());
        validators.add(new UserFirstNameValidator());
        validators.add(new UserLastNameValidator());
        validators.add(new UserPasswordValidator());
        validators.add(new UserPhoneValidator());
        validators.add(new UserNameValidator());
    }

    public List<String> validate(User user) {
        return validators.stream()
                .map(e -> e.validate(user))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
