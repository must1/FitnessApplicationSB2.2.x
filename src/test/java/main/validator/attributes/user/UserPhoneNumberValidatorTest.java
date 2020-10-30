package main.validator.attributes.user;

import main.model.user.User;
import main.validator.ErrorConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPhoneNumberValidatorTest {

    private final UserPhoneNumberValidator userPasswordValidator = new UserPhoneNumberValidator();

    @Test
    void shouldReturnNullWhenPhoneNumberIsNotValid() {
        //given
        User user = User.builder()
                .phoneNumber("500100")
                .build();

        //when
        String error = userPasswordValidator.validate(user);

        //then
        assertEquals(ErrorConstants.WRONG_PHONE_NUMBER_MESSAGE, error);
    }

    @Test
    void shouldReturnMessageWhenPhoneNumberIsValid() {
        //given
        User user = User.builder()
                .phoneNumber("+48500200100")
                .build();

        //when
        String error = userPasswordValidator.validate(user);

        //then
        assertNull(error);
    }

}