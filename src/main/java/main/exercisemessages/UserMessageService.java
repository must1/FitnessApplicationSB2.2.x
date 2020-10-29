package main.exercisemessages;

import main.model.user.UserMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMessageService {

    private final UserMessageRepository userMessageRepository;

    public UserMessageService(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }

    public List<String> getMessages(Long userID) {
        List<UserMessage> userMessages = userMessageRepository.getAllByUserId(userID);
        return userMessages.stream().map(UserMessage::getMessage).collect(Collectors.toList());
    }
}
