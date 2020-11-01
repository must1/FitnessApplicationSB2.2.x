package main.controller;

import main.model.user.User;
import main.user.UserCrudActivitiesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCrudActivitiesController {

    private final UserCrudActivitiesService userCrudActivitiesService;

    public UserCrudActivitiesController(UserCrudActivitiesService userCrudActivitiesService) {
        this.userCrudActivitiesService = userCrudActivitiesService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userCrudActivitiesService.getAllUsers();
    }

    @PostMapping("/createUser")
    public List<String> createUser(@RequestBody User user) {
        return userCrudActivitiesService.createUser(user);
    }

    @PutMapping("/user")
    public List<String> updateUser(@RequestBody User user) {
        return userCrudActivitiesService.updateUser(user);
    }
}
