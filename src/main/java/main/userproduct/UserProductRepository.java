package main.userproduct;

import main.model.UserProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserProductRepository extends CrudRepository<UserProduct, Long> {

    @Query("SELECT SUM(userProduct.fatNumber) from UserProduct userProduct WHERE :userID = userProduct.userID AND :date = userProduct.dateOfEatenProduct")
    double countFatForDay(@Param("userID") Long userID, @Param("date") LocalDate date);

    @Query("SELECT SUM(userProduct.proteinNumber) from UserProduct userProduct WHERE :userID = userProduct.userID AND :date = userProduct.dateOfEatenProduct")
    double countProteinsForDay(@Param("userID") Long userID, @Param("date") LocalDate date);

    @Query("SELECT SUM(userProduct.carbohydratesNumber) from UserProduct userProduct WHERE :userID = userProduct.userID AND :date = userProduct.dateOfEatenProduct")
    double countCarbohydratesForDay(@Param("userID") Long userID, @Param("date") LocalDate date);

    @Query("SELECT SUM(userProduct.kcalNumber) from UserProduct userProduct WHERE :userID = userProduct.userID AND :date = userProduct.dateOfEatenProduct")
    double countCaloriesForDay(@Param("userID") Long userID, @Param("date") LocalDate date);
}
