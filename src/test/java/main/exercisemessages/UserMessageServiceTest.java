package main.exercisemessages;

import main.model.user.UserMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserMessageServiceTest {

    @Autowired
    private UserMessageRepository userMessageRepository;

    private UUID uuid1;

    private UUID uuid2;

    @BeforeEach
    public void setup() {
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
        userMessageRepository.save(createUserMessage(uuid1, LocalDate.now()));
        userMessageRepository.save(createUserMessage(uuid1, LocalDate.now()));
        userMessageRepository.save(createUserMessage(uuid1, LocalDate.of(2020, 7, 20)));
        userMessageRepository.save(createUserMessage(uuid2, LocalDate.of(2020, 7, 20)));
        userMessageRepository.save(createUserMessage(uuid2, LocalDate.now()));
    }

    @Test
    public void shouldReturnProperAmountOfMessagesWhenSomeMessagesAreObsolete() {
        //given
        UserMessageService userMessageService = new UserMessageService(userMessageRepository);

        //when
        List<String> userMessages = userMessageService.getMessages(uuid1);

        //then
        assertThat(userMessages.size()).isEqualTo(2);
    }

    private UserMessage createUserMessage(UUID userID, LocalDate date) {
        return UserMessage
                .builder()
                .message("TEST")
                .userId(userID)
                .creationTime(date)
                .build();
    }

}