package main.controller;

import main.entity.User;
import main.user.UserCrudActivitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCrudActivitiesController {

    private final UserCrudActivitiesService userCrudActivitiesService;

    public UserCrudActivitiesController(UserCrudActivitiesService userCrudActivitiesService) {
        this.userCrudActivitiesService = userCrudActivitiesService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userCrudActivitiesService.getAllUsers();
    }

    @PostMapping("/createUser")
    public List<String> createUser(@RequestBody User user) {
        return userCrudActivitiesService.createUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userCrudActivitiesService.updateUser(user);
    }
}
