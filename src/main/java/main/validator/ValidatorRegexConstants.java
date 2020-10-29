package main.validator;

public interface ValidatorRegexConstants {

    //Minimum eight characters, at least one letter, one number and one special character:
    String PASSWORD_VALIDATION_REGEX = "\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$\"";

    // Only for polish numbers
    String PHONE_NUMBER_VALIDATION_REGEX = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)";
    /*- username is 5-20 characters long
    - no _ or . at the beginning
    - no __ or _. or ._ or .. inside
    - no special characters
    - no _ or . at the end*/
    String USERNAME_VALIDATION_REGEX = "^(?=[a-zA-Z0-9._]{5,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    String EMAIL_VALIDATION_REGEX = "\"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$\"";
}
