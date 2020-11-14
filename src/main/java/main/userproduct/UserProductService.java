package main.userproduct;

import main.model.Product;
import main.model.user.User;
import main.model.user.UserProduct;
import main.product.ProductRepository;
import main.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final UserProductRepository userProductRepository;

    @Autowired
    public UserProductService(UserProductRepository userProductRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userProductRepository = userProductRepository;
    }

    public Map<String, Double> getNutrientsOfGivenProductAndAddItToEatenByHimToDB(UserProduct userProduct, User user) {
        double gram = userProduct.getGram();
        double calculatedFat = MacroNutrientsCalculator.countFatNumberOfGivenProduct(gram, retrieveGivenProductFromDB(userProduct));
        double calculatedProtein = MacroNutrientsCalculator.countProteinNumberOfGivenProduct(gram, retrieveGivenProductFromDB(userProduct));
        double calculatedCarbohydrates = MacroNutrientsCalculator.countCarbohydratesNumberNumberOfGivenProduct(gram, retrieveGivenProductFromDB(userProduct));
        double calculatedKcal = MacroNutrientsCalculator.countCaloriesOfGivenProduct(gram, retrieveGivenProductFromDB(userProduct));

        addGivenProductToGivenUserInDB(user.getId(), userProduct.getName(), calculatedFat,
                calculatedProtein, calculatedCarbohydrates, (int) calculatedKcal);

        return Map.of(
                "calculatedFat", calculatedFat,
                "calculatedProtein", calculatedProtein,
                "calculatedCarbohydrates", calculatedCarbohydrates,
                "calculatedKcal", calculatedKcal);
    }

    private Product retrieveGivenProductFromDB(UserProduct productToCalculate) {
        if (productToCalculate.getGram() >= 0) {
            return productRepository.findByName(productToCalculate.getName())
                    .orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        } else {
            throw new IllegalArgumentException("Grams can not be negative");
        }
    }

    private void addGivenProductToGivenUserInDB(UUID userID, String name, double calculatedFat, double calculatedProtein, double calculatedCarbohydrates, int calculatedKcal) {
        if (doesAccountExist(userID)) {

            UserProduct userProduct =
                    UserProduct.builder()
                            .name(name)
                            .carbohydratesNumber(calculatedCarbohydrates)
                            .fatNumber(calculatedFat)
                            .kcalNumber(calculatedKcal)
                            .proteinNumber(calculatedProtein)
                            .dateOfEatenProduct(LocalDate.now())
                            .userID(userID)
                            .build();

            userProductRepository.save(userProduct);
        } else {
            throw new IllegalArgumentException("User does not exist with given ID!");
        }
    }

    private boolean doesAccountExist(UUID userID) {
        return userRepository.doesAccountExistsWithID(userID);
    }
}
