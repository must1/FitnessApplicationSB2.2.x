package main.product;

import main.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    Optional<Product> getById(UUID id);

    Optional<Product> findByName(String name);
}
