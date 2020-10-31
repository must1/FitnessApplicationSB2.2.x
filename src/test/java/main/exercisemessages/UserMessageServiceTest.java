package main.exercisemessages;

import main.model.user.UserMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
class UserMessageServiceTest {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @BeforeEach
    public void setup() {
        userMessageRepository.save(createUserMessage(1L, LocalDate.now()));
        userMessageRepository.save(createUserMessage(1L, LocalDate.now()));
        userMessageRepository.save(createUserMessage(1L, LocalDate.of(2020, 7, 20)));
        userMessageRepository.save(createUserMessage(2L, LocalDate.of(2020, 7, 20)));
        userMessageRepository.save(createUserMessage(2L, LocalDate.now()));
    }

    @Test
    public void shouldReturnProperAmountOfMessagesWhenSomeMessagesAreObsolete() {
        //given
        UserMessageService userMessageService = new UserMessageService(userMessageRepository);

        //when
        List<String> userMessages = userMessageService.getMessages(1L);

        //then
        assertThat(userMessages.size()).isEqualTo(2);
    }

    private UserMessage createUserMessage(Long userID, LocalDate date) {
        return UserMessage
                .builder()
                .message("TEST")
                .userId(userID)
                .creationTime(date)
                .build();
    }

}