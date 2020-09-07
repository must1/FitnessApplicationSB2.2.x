package main.userproduct;

import main.entity.UserProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductRepository extends CrudRepository<UserProduct, Long> {
}
