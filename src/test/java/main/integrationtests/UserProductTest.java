package main.integrationtests;

import main.exercise.BodyPartType;
import main.history.UserHistoryService;
import main.model.Product;
import main.model.user.User;
import main.model.user.UserHistory;
import main.model.user.UserProduct;
import main.product.ProductCrudActivitiesService;
import main.product.ProductRepository;
import main.product.ProductType;
import main.user.UserCrudActivitiesService;
import main.user.UserRepository;
import main.userproduct.UserProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserProductTest {

    @Autowired
    UserProductService userProductService;

    @Autowired
    UserCrudActivitiesService userCrudActivitiesService;

    @Autowired
    ProductCrudActivitiesService productCrudActivitiesService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserHistoryService userHistoryService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldReturnProperAmountOfEatenMacroNutrientsWhenAllDataIsProper() {
        User user = createUser();
        userCrudActivitiesService.createUser(user);
        User userFromRepository = userRepository.findByUsername(user.getUsername()).get();

        productCrudActivitiesService.createProduct(createProduct());

        userProductService.getNutrientsOfGivenProductAndAddItToEatenByHimToDB(createUserProduct(), userFromRepository);

        UserHistory userHistory = userHistoryService.getUserHistory(userFromRepository, LocalDate.now());

        assertThat(userHistory.getCarbohydratesNumber()).isEqualTo(2);
        assertThat(userHistory.getFatNumber()).isEqualTo(4.2);
        assertThat(userHistory.getProteinNumber()).isEqualTo(22.9);
        assertThat(userHistory.getKcalNumber()).isEqualTo(129);
    }

    private UserProduct createUserProduct() {
        Product product = createProduct();
        return UserProduct.builder()
                .name(product.getName())
                .gram(100)
                .build();
    }

    private User createUser() {
        return User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("must11")
                .email("lalaa@gmail.com")
                .password("!q2wqwqwqw")//123
                .roles(new HashSet<>(Collections.singletonList("ROLE_USER")))
                .phoneNumber("500999111")
                .favouriteBodyPartType(BodyPartType.CHEST)
                .build();
    }

    private Product createProduct() {
        return Product.builder()
                .name("UserProductTest")
                .carbohydratesNumberPer100G(2)
                .fatNumberPer100G(4.2)
                .proteinNumberPer100G(22.9)
                .kcalNumberPer100G(129)
                .type(ProductType.GRAIN)
                .build();
    }
}
