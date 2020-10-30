package main.validator.attributes.user;

import main.model.user.User;
import main.validator.ErrorConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UsernameValidatorTest {

    private final UsernameValidator usernameValidator = new UsernameValidator();

    @Test
    void shouldReturnNullWhenUsernameIsNotValid() {
        //given
        User user = User.builder()
                .username("!QEQ")
                .build();

        //when
        String error = usernameValidator.validate(user);

        //then
        assertEquals(ErrorConstants.WRONG_USERNAME_MESSAGE, error);
    }

    @Test
    void shouldReturnMessageWhenUsernameIsValid() {
        //given
        User user = User.builder()
                .username("username")
                .build();

        //when
        String error = usernameValidator.validate(user);

        //then
        assertNull(error);
    }
}