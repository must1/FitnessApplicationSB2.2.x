package main.userproduct;

import main.model.user.UserProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserProductRepositoryTest {

    @Autowired
    private UserProductRepository userProductRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setup() {
        persistEntityToEntityManager(1L, LocalDate.now());
        persistEntityToEntityManager(1L, LocalDate.now());
        persistEntityToEntityManager(1L, LocalDate.now().minusDays(1));
        persistEntityToEntityManager(2L, LocalDate.now());
    }

    @Test
    public void shouldReturnProperAmountOfCalories() {
        double actualCalories = userProductRepository.countCaloriesForDay(1L, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfFat() {
        double actualCalories = userProductRepository.countFatForDay(1L, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfProteins() {
        double actualCalories = userProductRepository.countProteinsForDay(1L, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfCarbohydrates() {
        double actualCalories = userProductRepository.countCarbohydratesForDay(1L, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    public void persistEntityToEntityManager(Long userID, LocalDate date) {
        UserProduct userProduct = createUserProduct(userID, date);
        entityManager.persist(userProduct);
        entityManager.flush();
    }

    private UserProduct createUserProduct(Long userID, LocalDate date) {
        return UserProduct.builder()
                .carbohydratesNumber(20)
                .fatNumber(20)
                .dateOfEatenProduct(date)
                .gram(20)
                .kcalNumber(20)
                .proteinNumber(20)
                .name("Chicken")
                .userID(userID).build();
    }
}