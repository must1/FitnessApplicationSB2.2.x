package main.validator.productvalidator.attributesvalidators;

import main.model.Product;

public class ProductMacronutrientsValidator implements ProductAttributesValidator {

    public static final int MAXIMUM_NUMBER_OF_MACRONUTRIENTS = 999;

    @Override
    public String validate(Product product) {
        if (product.getCarbohydratesNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of carbohydrates!";
        else if (product.getProteinNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of proteins!";
        else if (product.getFatNumberPer100G() > MAXIMUM_NUMBER_OF_MACRONUTRIENTS)
            return "Too much of fat!";

        return null;
    }
}
