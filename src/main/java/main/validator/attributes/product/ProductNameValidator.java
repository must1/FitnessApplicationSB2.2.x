package main.validator.attributes.product;

import main.model.Product;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_PRODUCT_NAME_MESSAGE;

@Component
public class ProductNameValidator implements Validator<Product> {

    @Override
    public String validate(Product product) {
        String attribute = product.getName();
        return attribute.isEmpty() ? EMPTY_PRODUCT_NAME_MESSAGE : null;
    }
}
