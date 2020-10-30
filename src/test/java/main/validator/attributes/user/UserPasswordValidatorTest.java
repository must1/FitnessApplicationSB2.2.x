package main.validator.attributes.user;

import main.model.user.User;
import main.validator.ErrorConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserPasswordValidatorTest {

    private final UserPasswordValidator userPasswordValidator = new UserPasswordValidator();

    @Test
    void shouldReturnNullWhenPasswordIsNotValid() {
        //given
        User user = User.builder()
                .password("123")
                .build();

        //when
        String error = userPasswordValidator.validate(user);

        //then
        assertEquals(ErrorConstants.WRONG_PASSWORD_MESSAGE, error);
    }

    @Test
    void shouldReturnMessageWhenPasswordIsValid() {
        //given
        User user = User.builder()
                .password("!q2wqwqwqw")
                .build();

        //when
        String error = userPasswordValidator.validate(user);

        //then
        assertNull(error);
    }
}