package main.userproduct;

import main.entity.Product;
import main.entity.User;
import main.entity.UserProduct;
import main.product.ProductRepository;
import main.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        addGivenProductToGivenUserInDB(user.getId(), calculatedFat,
                calculatedProtein, calculatedCarbohydrates, (int) calculatedKcal);

        return Map.of(
                "calculatedFat", calculatedFat,
                "calculatedProtein", calculatedProtein,
                "calculatedCarbohydrates", calculatedCarbohydrates,
                "calculatedKcal", calculatedKcal);
    }

    private Product retrieveGivenProductFromDB(UserProduct productToCalculate) {
        if (productToCalculate.getGram() > 0) {
            return productRepository.findByName(productToCalculate.getName())
                    .orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        } else {
            throw new IllegalArgumentException("Grams can not be negative");
        }
    }

    //calculate and add product o user
    private void addGivenProductToGivenUserInDB(long userID, double calculatedFat, double calculatedProtein, double calculatedCarbohydrates, int calculatedKcal) {
        if (checkIfGivenAccountExist(userID)) {

            UserProduct userProduct = new UserProduct();
            UserProduct.builder()
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

    private boolean checkIfGivenAccountExist(long userID) {
        return userRepository.doesAccountExistsWithGivenID(userID);
    }

    public List<UserProduct> getUserProducts() {
        List<UserProduct> products = new ArrayList<>();
        userProductRepository.findAll().forEach(products::add);
        return products;
    }
}
