package main.validator.productvalidator.attributesvalidators;

import main.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductValidator {

    private final List<ProductAttributesValidator> validators;

    public ProductValidator() {
        validators = new ArrayList<>();
        validators.add(new ProductNameValidator());
        validators.add(new ProductMacronutrientsValidator());
    }

    public List<String> validate(Product product) {
        return validators.stream()
                .map(e -> e.validate(product))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
