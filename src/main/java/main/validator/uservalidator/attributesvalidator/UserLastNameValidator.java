package main.validator.uservalidator.attributesvalidator;

import main.entity.User;

public class UserLastNameValidator implements IUserAttributesValidator {

    public static final int NAME_MAXIMUM_LENGTH = 30;
    public static final int NAME_MINIMUM_LENGTH = 3;
    public static final String NAME_ILLEGAL_CHARACTER_REGEX = "[A-Za-z0-9]+";

    @Override
    public String validate(User user) {
        String attribute = user.getLastName();
        if (attribute.length() > NAME_MAXIMUM_LENGTH) {
            return "lastName is too long";
        } else if (attribute.length() < NAME_MINIMUM_LENGTH) {
            return "lastName is too short";
        } else if (!attribute.matches(NAME_ILLEGAL_CHARACTER_REGEX)) {
            return "lastName contains illegal character";
        }
        return null;
    }
}
