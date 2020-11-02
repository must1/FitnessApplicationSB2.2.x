package main.controller;

import main.model.Product;
import main.product.ProductCrudActivitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/product")
    public Product getProductsForId(@RequestParam("id") UUID id) {
        return productCrudActivitiesService.getProductForId(id);
    }

    @PostMapping("/createProduct")
    public List<String> createProduct(@RequestBody Product newProduct) {
        return productCrudActivitiesService.createProduct(newProduct);
    }

    @PutMapping("/product")
    public List<String> updateProduct(@RequestBody Product updatedProduct) {
        return productCrudActivitiesService.updateProduct(updatedProduct);
    }
}
