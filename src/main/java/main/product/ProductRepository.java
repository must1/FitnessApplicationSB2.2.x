package main.product;

import main.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<Product> getById(int id);

    Optional<Product> findByName(String name);
}
