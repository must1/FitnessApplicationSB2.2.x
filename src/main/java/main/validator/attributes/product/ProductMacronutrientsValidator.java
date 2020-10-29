package main.validator.attributes.product;

import main.model.Product;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.*;

@Component
public class ProductMacronutrientsValidator implements Validator<Product> {

    public static final int MAXIMUM_NUMBER_OF_MACRONUTRIENTS = 999;

    @Override
    public String validate(Product product) {
        if (product.getCarbohydratesNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return TOO_MUCH_CARBOHYDRATES_MESSAGE;
        else if (product.getProteinNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return TOO_MUCH_PROTEIN_MESSAGE;
        else if (product.getFatNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return TOO_MUCH_FAT_MESSAGE;

        return null;
    }
}
