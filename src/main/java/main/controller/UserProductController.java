package main.controller;

import main.model.user.User;
import main.model.user.UserProduct;
import main.userproduct.UserProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserProductController {

    private final UserProductService userProductService;

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @PostMapping("/nutrients")
    public Map<String, Double> getNutrientsOfGivenProductAndAddItToEatenByHimToDB(@RequestBody UserProduct userProduct, @AuthenticationPrincipal User requester) {
        return userProductService.getNutrientsOfGivenProductAndAddItToEatenByHimToDB(userProduct, requester);
    }

    @GetMapping("/userproduct") // for tests
    public List<UserProduct> getUserProducts() {
        return userProductService.getUserProducts();
    }
}
