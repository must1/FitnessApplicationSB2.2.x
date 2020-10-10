package main.validator.uservalidator.attributesvalidator;

import main.model.user.User;

public class UserPhoneValidator implements IUserAttributesValidator {

    public static final int PHONE_NUMBER_LENGTH = 9;
    public static final String ILLEGAL_PHONE_NUMBER_REGEX = "[0-9]+";

    @Override
    public String validate(User user) {
        String attribute = user.getPhoneNumber();
        if (attribute.length() != PHONE_NUMBER_LENGTH) {
            return "9 digits of phone number is required!";
        } else if (!attribute.matches(ILLEGAL_PHONE_NUMBER_REGEX)) {
            return "phone number must consist of numbers";
        }
        return null;
    }
}
