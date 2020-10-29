package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_PHONE_NUMBER_MESSAGE;
import static main.validator.ErrorConstants.WRONG_PHONE_NUMBER_MESSAGE;
import static main.validator.ValidatorRegexConstants.PHONE_NUMBER_VALIDATION_REGEX;

@Component
public class UserPhoneNumberValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getPhoneNumber();
        if (attribute.isEmpty()) {
            return EMPTY_PHONE_NUMBER_MESSAGE;
        } else if (!attribute.matches(PHONE_NUMBER_VALIDATION_REGEX)) {
            return WRONG_PHONE_NUMBER_MESSAGE;
        }
        return null;
    }
}
