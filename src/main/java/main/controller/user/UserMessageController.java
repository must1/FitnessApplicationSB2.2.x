package main.controller.user;

import main.exercisemessages.UserMessageService;
import main.model.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMessageController {

    private final UserMessageService userMessageService;

    public UserMessageController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @GetMapping("/usermessages")
    List<String> getMessages(@AuthenticationPrincipal User requester) {
        return userMessageService.getMessages(requester.getId());
    }
}
