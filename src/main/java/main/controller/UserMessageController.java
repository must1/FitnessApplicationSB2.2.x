package main.controller;

import main.exercisemessages.UserMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMessageController {

    private final UserMessageService userMessageService;

    public UserMessageController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @GetMapping("/usermessages")
    List<String> getMessages(@RequestParam("id") Long userID) {
        return userMessageService.getMessages(userID);
    }
}
