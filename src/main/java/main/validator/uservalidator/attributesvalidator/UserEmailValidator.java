package main.validator.uservalidator.attributesvalidator;

import main.entity.User;

public class UserEmailValidator implements IUserAttributesValidator {

    public static final String MAIL_ILLEGAL_CHARACTERS_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @Override
    public String validate(User user) {
        String attribute = user.getEmail();
        if (!attribute.matches(MAIL_ILLEGAL_CHARACTERS_REGEX)) {
            return "incorrect email address";
        }
        return null;
    }

}
