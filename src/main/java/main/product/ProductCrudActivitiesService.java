package main.product;

import main.model.Product;
import main.validator.attributes.product.ProductValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCrudActivitiesService {

    private final ProductRepository productRepository;

    private final ProductValidator productValidator;

    public ProductCrudActivitiesService(ProductRepository productRepository, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productValidator = productValidator;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public List<String> createProduct(Product newProduct) {
        List<String> messages = productValidator.validate(newProduct);
        if (CollectionUtils.isEmpty(messages)) {
            productRepository.save(newProduct);
        }
        return messages;
    }

    public List<String> updateProduct(Product productToUpdate) {
        List<String> messages = productValidator.validate(productToUpdate);

        if (CollectionUtils.isEmpty(messages)) {
            productRepository.save(productToUpdate);
        }

        return messages;
    }

    //todo stescic to
    public Product getProductForId(int id) {
        return productRepository.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " was not found"));
    }
}
