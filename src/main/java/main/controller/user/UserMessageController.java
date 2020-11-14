package main.controller.user;

import main.exercisemessages.UserMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserMessageController {

    private final UserMessageService userMessageService;

    public UserMessageController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @GetMapping("/usermessages")
    List<String> getMessages(@RequestParam("id") UUID userID) {
        return userMessageService.getMessages(userID);
    }
}
