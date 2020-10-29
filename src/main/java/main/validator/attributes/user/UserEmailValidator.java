package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_EMAIL_MESSAGE;
import static main.validator.ErrorConstants.WRONG_EMAIL_MESSAGE;
import static main.validator.ValidatorRegexConstants.EMAIL_VALIDATION_REGEX;

@Component
public class UserEmailValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getEmail();
        if (attribute.isEmpty()) {
            return EMPTY_EMAIL_MESSAGE;
        } else if (!attribute.matches(EMAIL_VALIDATION_REGEX)) {
            return WRONG_EMAIL_MESSAGE;
        }
        return null;
    }

}
