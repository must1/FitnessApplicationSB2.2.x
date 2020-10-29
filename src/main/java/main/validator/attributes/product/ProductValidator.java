package main.validator.attributes.product;

import main.model.Product;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductValidator {

    private final List<Validator<Product>> validators;

    public ProductValidator(List<Validator<Product>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Product product) {
        return validators.stream()
                .map(e -> e.validate(product))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
