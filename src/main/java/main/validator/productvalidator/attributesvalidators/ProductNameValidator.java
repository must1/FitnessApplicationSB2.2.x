package main.validator.productvalidator.attributesvalidators;

import main.entity.Product;

public class ProductNameValidator implements ProductAttributesValidator {

    public static final int NAME_MAXIMUM_LENGTH = 30;
    public static final String NAME_ILLEGAL_CHARACTERS_REGEX = "^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$";

    @Override
    public String validate(Product product) {
        String attribute = product.getName();
        if (attribute.length() > NAME_MAXIMUM_LENGTH) {
            return "name is too long";
        } else if (!attribute.matches(NAME_ILLEGAL_CHARACTERS_REGEX)) {
            return "name contains illegal character";
        }
        return null;
    }
}
