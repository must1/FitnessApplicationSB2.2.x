package main.userproduct;

import lombok.experimental.UtilityClass;
import main.entity.Product;

@UtilityClass
public class MacroNutrientsCalculator {

    private final int ONE_HUNDRED_GRAMS = 100;

    double countFatNumberOfGivenProduct(double gram, Product product) {
        double fatNumber = product.getFatNumberPer100G();
        return (fatNumber * gram) / ONE_HUNDRED_GRAMS;
    }

    double countProteinNumberOfGivenProduct(double gram, Product product) {
        double proteinNumber = product.getProteinNumberPer100G();
        return (proteinNumber * gram) / ONE_HUNDRED_GRAMS;
    }

    double countCarbohydratesNumberNumberOfGivenProduct(double gram, Product product) {
        double carbohydratesNumber = product.getCarbohydratesNumberPer100G();
        return (carbohydratesNumber * gram) / ONE_HUNDRED_GRAMS;
    }

    double countCaloriesOfGivenProduct(double gram, Product product) {
        int kcalNumber = product.getKcalNumberPer100G();
        return (kcalNumber * gram) / ONE_HUNDRED_GRAMS;
    }
}
