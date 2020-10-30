package main.userproduct;

import main.model.Product;
import main.product.ProductType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MacroNutrientsCalculatorTest {

    @Test
    void shouldCalculateProperFat() {
        double calculatedFat = MacroNutrientsCalculator.countFatNumberOfGivenProduct(100, createProduct());

        assertEquals(1.3d, calculatedFat);
    }

    @Test
    void shouldCalculateProperProteins() {
        double calculatedProteins = MacroNutrientsCalculator.countProteinNumberOfGivenProduct(100, createProduct());

        assertEquals(21.5, calculatedProteins);
    }

    @Test
    void shouldCalculateProperCarbohydrates() {
        double calculatedCarbohydrates = MacroNutrientsCalculator.countCarbohydratesNumberNumberOfGivenProduct(100, createProduct());

        assertEquals(0, calculatedCarbohydrates);
    }

    @Test
    void shouldCalculateProperCalories() {
        double calculatedCalories = MacroNutrientsCalculator.countCaloriesOfGivenProduct(100, createProduct());

        assertEquals(99, calculatedCalories);
    }

    private Product createProduct() {
        return Product.builder()
                .name("Chicken")
                .carbohydratesNumberPer100G(0)
                .fatNumberPer100G(1.3)
                .proteinNumberPer100G(21.5)
                .kcalNumberPer100G(99)
                .type(ProductType.MEAT)
                .build();
    }

}