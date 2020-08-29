package main.validator.uservalidator.attributesvalidator;

import main.entity.User;

public class UserPasswordValidator implements IUserAttributesValidator {

    public static final int PASSWORD_MINIMUM_LENGTH = 3;

    @Override
    public String validate(User user) {
        String attribute = user.getPassword();
        if (attribute.length() < PASSWORD_MINIMUM_LENGTH) {
            return "password is too short";
        }

        return null;
    }
}
