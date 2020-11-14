package main.controller;

import main.model.Product;
import main.product.ProductCrudActivitiesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCrudActivitiesController {

    private final ProductCrudActivitiesService productCrudActivitiesService;

    public ProductCrudActivitiesController(ProductCrudActivitiesService productCrudActivitiesService) {
        this.productCrudActivitiesService = productCrudActivitiesService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productCrudActivitiesService.getAllProducts();
    }

    @PostMapping("/createProduct")
    public List<String> createProduct(@RequestBody Product newProduct) {
        return productCrudActivitiesService.createProduct(newProduct);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/product")
    public List<String> updateProduct(@RequestBody Product updatedProduct) {
        return productCrudActivitiesService.updateProduct(updatedProduct);
    }
}
