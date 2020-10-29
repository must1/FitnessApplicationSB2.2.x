package main.validator.attributes.user;

import main.model.user.User;
import main.validator.ValidatorRegexConstants;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_USERNAME_MESSAGE;
import static main.validator.ErrorConstants.WRONG_USERNAME_MESSAGE;

@Component
public class UsernameValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getUsername();
        if (attribute.isEmpty()) {
            return EMPTY_USERNAME_MESSAGE;
        } else if (!attribute.matches(ValidatorRegexConstants.USERNAME_VALIDATION_REGEX)) {
            return WRONG_USERNAME_MESSAGE;
        }
        return null;
    }
}
