package main.user;

import main.exercise.BodyPartType;
import main.model.user.User;
import main.validator.attributes.user.UserAttributesValidator;
import main.validator.availability.user.UserAvailabilityValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserCrudActivitiesServiceTest {

    @Autowired
    private UserRepository userRepository;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private UserAvailabilityValidator userAvailabilityValidator;

    @MockBean
    private UserAttributesValidator userAttributesValidator;

    @Test
    public void shouldNotCreateUserWhenVariablesAreNotAvailable() {
        UserCrudActivitiesService userCrudActivitiesService = new UserCrudActivitiesService(
                userRepository,
                userAvailabilityValidator,
                userAttributesValidator);

        User user = createUser();

        List<String> errors = Collections.singletonList("TEST");

        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("123");
        when(userAttributesValidator.validate(user)).thenReturn(errors);
        when(userAvailabilityValidator.validate(user)).thenReturn(errors);

        userCrudActivitiesService.createUser(user);

        assertThat(userRepository.findByUsername(user.getUsername())).isEqualTo(Optional.empty());
    }

    @Test
    public void shouldCreateUserWhenVariablesAreAvailable() {
        UserCrudActivitiesService userCrudActivitiesService = new UserCrudActivitiesService(
                userRepository,
                userAvailabilityValidator,
                userAttributesValidator);

        User user = createUser();

        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("123");

        userCrudActivitiesService.createUser(user);

        assertThat(userRepository.findByUsername(user.getUsername())).isNotNull();
    }

    private User createUser() {
        return User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("must1")
                .email("penetrat@gmail.com")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .phoneNumber("213702137")
                .favouriteBodyPartType(BodyPartType.CHEST)
                .build();
    }
}