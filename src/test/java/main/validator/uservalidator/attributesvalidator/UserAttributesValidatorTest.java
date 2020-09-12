package main.validator.uservalidator.attributesvalidator;

import main.entity.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class UserAttributesValidatorTest {


    @Test
    void shouldReturnEmptyListWhenProperDataIsPassed() {
        User user = prepareUserWithProperData("Macko", "54321");

        UserAttributesValidator userAttributesValidator = new UserAttributesValidator();

        List<String> errors = userAttributesValidator.validate(user);

        assertThat(errors).hasSize(0);
    }

    @Test
    void shouldReturnNotEmptyListWhenImproperDataIsPassed() {
        User user = prepareUserWithProperData("M", "5");

        UserAttributesValidator userAttributesValidator = new UserAttributesValidator();

        List<String> errors = userAttributesValidator.validate(user);

        assertThat(errors).isNotEmpty();
    }

    private User prepareUserWithProperData(String firstName, String password) {
        return User.builder()
                .firstName(firstName)
                .lastName("Bogdaniec")
                .username("admin1")
                .email("penetrator@gmail.com")
                .password(password)
                .phoneNumber("213702137")
                .build();
    }
}