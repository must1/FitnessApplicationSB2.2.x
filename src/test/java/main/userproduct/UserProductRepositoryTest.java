package main.userproduct;

import main.model.user.UserProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaRepositories(basePackages = "main")
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserProductRepositoryTest {

    @Autowired
    private UserProductRepository userProductRepository;

    @Autowired
    private TestEntityManager entityManager;

    private UUID uuid1;

    private UUID uuid2;

    @BeforeEach
    public void setup() {
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
        persistEntityToEntityManager(uuid1, LocalDate.now());
        persistEntityToEntityManager(uuid1, LocalDate.now());
        persistEntityToEntityManager(uuid1, LocalDate.now().minusDays(1));
        persistEntityToEntityManager(uuid2, LocalDate.now());
    }

    @Test
    public void shouldReturnProperAmountOfCalories() {
        double actualCalories = userProductRepository.countCaloriesForDay(uuid1, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfFat() {
        double actualCalories = userProductRepository.countFatForDay(uuid1, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfProteins() {
        double actualCalories = userProductRepository.countProteinsForDay(uuid1, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    @Test
    public void shouldReturnProperAmountOfCarbohydrates() {
        double actualCalories = userProductRepository.countCarbohydratesForDay(uuid1, LocalDate.now());
        assertThat(actualCalories).isEqualTo(40);
    }

    public void persistEntityToEntityManager(UUID userID, LocalDate date) {
        UserProduct userProduct = createUserProduct(userID, date);
        entityManager.persist(userProduct);
        entityManager.flush();
    }

    private UserProduct createUserProduct(UUID userID, LocalDate date) {
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