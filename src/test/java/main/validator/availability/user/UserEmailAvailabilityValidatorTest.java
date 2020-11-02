package main.validator.availability.user;

import main.exercise.BodyPartType;
import main.model.user.User;
import main.user.UserRepository;
import main.validator.ErrorConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserEmailAvailabilityValidatorTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldReturnNullWhenEmailIsAvailable() {
        //given
        User user = User.builder()
                .email("mail@gmail.com")
                .password("123")
                .favouriteBodyPartType(BodyPartType.BICEPS)
                .lastName("asd")
                .firstName("asd")
                .username("asd")
                .phoneNumber("510")
                .build();

        userRepository.save(user);

        UserEmailAvailabilityValidator userEmailAvailabilityValidator =
                new UserEmailAvailabilityValidator(userRepository);

        //when
        String error = userEmailAvailabilityValidator.validate(user);

        //then
        assertEquals(ErrorConstants.NOT_AVAILABLE_EMAIL_MESSAGE, error);
    }

    @Test
    void shouldReturnMessageWhenEmailIsNotAvailable() {
        //given
        User user = User.builder()
                .email("mail@gmail.com")
                .build();

        UserEmailAvailabilityValidator userEmailAvailabilityValidator =
                new UserEmailAvailabilityValidator(userRepository);

        //when
        String error = userEmailAvailabilityValidator.validate(user);

        //then
        assertNull(error);
    }
}