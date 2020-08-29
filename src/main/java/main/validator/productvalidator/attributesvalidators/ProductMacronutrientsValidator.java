package main.validator.productvalidator.attributesvalidators;

import main.entity.Product;

public class ProductMacronutrientsValidator implements ProductAttributesValidator {

    public static final int MAXIMUM_NUMBER_OF_MACRONUTRIENTS = 999;

    @Override
    public String validate(Product product) {
        if (product.getCarbohydratesNumber() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of carbohydrates!";
        else if (product.getProteinNumber() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of proteints!";
        else if (product.getFatNumber() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of fat!";

        return null;
    }
}
