package main.validator.uservalidator.availabilityvalidators;

import main.entity.User;
import main.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAvailabilityValidatorTest {

    @Mock
    UserRepository userRepository;

    @Test
    void shouldReturnEmptyListWhenProperDataIsPassed() {
        UserAvailabilityValidator userAvailabilityValidator = new UserAvailabilityValidator(userRepository);

        when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userRepository.findByPhoneNumber(any())).thenReturn(Optional.empty());

        List<String> errors = userAvailabilityValidator.validate(mock(User.class));

        assertThat(errors).hasSize(0);
    }

    @Test
    void shouldReturnNotEmptyListWhenProperDataIsPassed() {
        UserAvailabilityValidator userAvailabilityValidator = new UserAvailabilityValidator(userRepository);

        when(userRepository.findByUsername(any())).thenReturn(Optional.of(new User()));
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userRepository.findByPhoneNumber(any())).thenReturn(Optional.empty());

        List<String> errors = userAvailabilityValidator.validate(mock(User.class));

        assertThat(errors).isNotEmpty();
    }

}