package main.validator.uservalidator.attributesvalidator;

import main.model.user.User;

public class UserFirstNameValidator implements IUserAttributesValidator {

    public static final int FIRST_NAME_MAXIMUM_LENGTH = 30;
    public static final int FIRST_NAME_MINIMUM_LENGTH = 3;
    public static final String FIRST_NAME_ILLEGAL_CHARACTER_REGEX = "[A-Za-z0-9]+";

    @Override
    public String validate(User user) {
        String attribute = user.getFirstName();
        if (attribute.length() > FIRST_NAME_MAXIMUM_LENGTH) {
            return "firstName is too long";
        } else if (attribute.length() < FIRST_NAME_MINIMUM_LENGTH) {
            return "firstName is too short";
        } else if (!attribute.matches(FIRST_NAME_ILLEGAL_CHARACTER_REGEX)) {
            return "firstName contains illegal character";
        }
        return null;
    }
}
