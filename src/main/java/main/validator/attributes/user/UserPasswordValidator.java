package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_PASSWORD_MESSAGE;
import static main.validator.ErrorConstants.WRONG_PASSWORD_MESSAGE;
import static main.validator.ValidatorRegexConstants.PASSWORD_VALIDATION_REGEX;

@Component
public class UserPasswordValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getPassword();
        if (attribute.isEmpty()) {
            return EMPTY_PASSWORD_MESSAGE;
        } else if (!attribute.matches(PASSWORD_VALIDATION_REGEX)) {
            return WRONG_PASSWORD_MESSAGE;
        }
        return null;
    }
}
