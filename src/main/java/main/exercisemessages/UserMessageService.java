package main.exercisemessages;

import main.model.user.UserMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserMessageService {

    private final UserMessageRepository userMessageRepository;

    public UserMessageService(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }

    public List<String> getMessages(UUID userID) {
        performRemovingObsoleteMessagesProcess(userID);
        List<UserMessage> actualUserMessages = userMessageRepository.getAllByUserId(userID);

        return actualUserMessages
                .stream()
                .map(UserMessage::getMessage)
                .collect(Collectors.toList());
    }

    private void performRemovingObsoleteMessagesProcess(UUID userID) {
        List<UserMessage> userMessages = userMessageRepository.getAllByUserId(userID);
        checkIfContainsObsoleteMessagesAndRemoveIfSo(userMessages);
    }


    private void checkIfContainsObsoleteMessagesAndRemoveIfSo(List<UserMessage> userMessages) {
        userMessages.forEach(userMessage -> {
            LocalDate currentDate = LocalDate.now();
            LocalDate newDate = userMessage.getCreationTime();
            Period period = Period.between(currentDate, newDate);
            if (period.getDays() <= -1) {
                userMessageRepository.delete(userMessage);
            }
        });
    }

}

