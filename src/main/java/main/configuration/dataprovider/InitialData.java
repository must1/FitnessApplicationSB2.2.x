package main.configuration.dataprovider;

import lombok.extern.slf4j.Slf4j;
import main.model.Exercise;
import main.model.Product;
import main.model.User;
import main.exercise.ExerciseRepository;
import main.exercise.ExerciseType;
import main.product.ProductRepository;
import main.product.ProductType;
import main.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialData {

    /*    private final ProductRepository productRepository;
        private final AccountRepository accountRepository;*/
    private final ExerciseRepository exerciseRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public InitialData(ProductRepository productRepository, UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

/*    @EventListener(ContextRefreshedEvent.class)
    public void addFruitsToDB() {
        log.info("Persisted fruit data to database");
        productRepository.save(new Product.ProductBuilder()
                .withName("Apple")
                .withCarbohydratesNumber(10.1)
                .withFatNumber(0.4)
                .withProteinsNumber(0.4)
                .withKcal(50)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Orange")
                .withCarbohydratesNumber(12)
                .withFatNumber(0.1)
                .withProteinsNumber(0.9)
                .withKcal(47)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Banana")
                .withCarbohydratesNumber(21.8)
                .withFatNumber(0.3)
                .withProteinsNumber(1)
                .withKcal(97)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Strawberry")
                .withCarbohydratesNumber(5.8)
                .withFatNumber(0.4)
                .withProteinsNumber(0.7)
                .withKcal(33)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Peach")
                .withCarbohydratesNumber(10)
                .withFatNumber(0.2)
                .withProteinsNumber(1)
                .withKcal(47)
                .withType(ProductType.FRUIT)
                .build());
    }*/

    @EventListener(ContextRefreshedEvent.class)
    public void addMeatToDB() {
        log.info("Persisted products to database");

        productRepository.save(Product.builder()
                .name("Chicken")
                .carbohydratesNumberPer100G(0)
                .fatNumberPer100G(1.3)
                .proteinNumberPer100G(21.5)
                .kcalNumberPer100G(99)
                .type(ProductType.MEAT)
                .build());

        productRepository.save(Product.builder()
                .name("Turkey")
                .carbohydratesNumberPer100G(0)
                .fatNumberPer100G(0.7)
                .proteinNumberPer100G(19.2)
                .kcalNumberPer100G(84)
                .type(ProductType.MEAT)
                .build());

        productRepository.save(Product.builder()
                .name("Bread")
                .carbohydratesNumberPer100G(2)
                .fatNumberPer100G(4.2)
                .proteinNumberPer100G(22.9)
                .kcalNumberPer100G(129)
                .type(ProductType.GRAIN)
                .build());
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addUsersToDB() {
        log.info("Persisted account data to database");

        userRepository.save(User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("must1")
                .email("penetrat@gmail.com")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .phoneNumber("213702137")
                .build());

        userRepository.save(User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("admin1")
                .email("penetrator@gmail.com")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .phoneNumber("213702137")
                .build());

    }


    @EventListener(ContextRefreshedEvent.class)
    public void addExercisesToDB() {

        log.info("Persisted exercises data to database");

        exerciseRepository.save(Exercise.builder()
                .name("Running")
                .exerciseType(ExerciseType.CARDIO)
                .exerciseDescription("Description")
                .build());

        exerciseRepository.save(Exercise.builder()
                .name("Deadlifting")
                .exerciseType(ExerciseType.WEIGHTLIFTING)
                .exerciseDescription("Description")
                .build());
    }
}