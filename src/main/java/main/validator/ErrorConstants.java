package main.validator;

public interface ErrorConstants {

    String EMPTY_PASSWORD_MESSAGE = "Password cannot be empty";
    String EMPTY_USERNAME_MESSAGE = "Username cannot be empty";
    String EMPTY_FIRST_NAME_MESSAGE = "First name cannot be empty";
    String EMPTY_LAST_NAME_MESSAGE = "Last name cannot be empty";
    String EMPTY_PRODUCT_NAME_MESSAGE = "Product name cannot be empty";
    String EMPTY_EXERCISE_NAME_MESSAGE = "Exercise  name cannot be empty";

    String EMPTY_EMAIL_MESSAGE = "Email cannot be empty";
    String EMPTY_PHONE_NUMBER_MESSAGE = "Phone number cannot be empty";

    String WRONG_USERNAME_MESSAGE = "Username is invalid";
    String WRONG_PHONE_NUMBER_MESSAGE = "Phone number is invalid";
    String WRONG_EMAIL_MESSAGE = "Email is invalid";
    String WRONG_PASSWORD_MESSAGE = "Password is invalid";

    String NOT_AVAILABLE_EMAIL_MESSAGE = "Email is already taken";
    String NOT_AVAILABLE_USERNAME_MESSAGE = "Username is already taken";
    String NOT_AVAILABLE_PHONE_NUMBER_MESSAGE = "Phone number is already taken";

    String TOO_MUCH_FAT_MESSAGE = "Too much fat";
    String TOO_MUCH_PROTEIN_MESSAGE = "Too much protein";
    String TOO_MUCH_CARBOHYDRATES_MESSAGE = "Too much carbohydrates";
}
