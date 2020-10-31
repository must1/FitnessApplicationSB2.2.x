package main.userproduct;

import main.model.Product;
import main.product.ProductType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MacroNutrientsCalculatorTest {

    @Test
    void shouldCalculateProperFat() {
        double calculatedFat = MacroNutrientsCalculator.countFatNumberOfGivenProduct(100, createProduct());

        assertThat(calculatedFat).isEqualTo(1.3d);
    }

    @Test
    void shouldCalculateProperProteins() {
        double calculatedProteins = MacroNutrientsCalculator.countProteinNumberOfGivenProduct(100, createProduct());

        assertThat(calculatedProteins).isEqualTo(21.5);
    }

    @Test
    void shouldCalculateProperCarbohydrates() {
        double calculatedCarbohydrates = MacroNutrientsCalculator.countCarbohydratesNumberNumberOfGivenProduct(100, createProduct());

        assertThat(calculatedCarbohydrates).isEqualTo(0);
    }

    @Test
    void shouldCalculateProperCalories() {
        double calculatedCalories = MacroNutrientsCalculator.countCaloriesOfGivenProduct(100, createProduct());

        assertThat(calculatedCalories).isEqualTo(99);
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