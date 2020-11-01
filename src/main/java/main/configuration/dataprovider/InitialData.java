package main.configuration.dataprovider;

import lombok.extern.slf4j.Slf4j;
import main.exercise.BodyPartType;
import main.exercise.ExerciseRepository;
import main.model.Exercise;
import main.model.Product;
import main.model.Role;
import main.model.user.User;
import main.product.ProductRepository;
import main.product.ProductType;
import main.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@Component
@Slf4j
public class InitialData {

    private final ExerciseRepository exerciseRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public InitialData(ProductRepository productRepository, UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

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
                .roles(new HashSet<>(Collections.singletonList(new Role("ROLE_ADMIN"))))
                .favouriteBodyPartType(BodyPartType.CHEST)
                .build());

        userRepository.save(User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("admin1")
                .email("penetrator@gmail.com")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .roles(new HashSet<>(Collections.singletonList(new Role("ROLE_USER"))))
                .phoneNumber("213702137")
                .favouriteBodyPartType(BodyPartType.BICEPS)
                .build());
    }


    @EventListener(ContextRefreshedEvent.class)
    public void addExercisesToDB() {

        log.info("Persisted exercises data to database");

        exerciseRepository.save(Exercise.builder()
                .name("Running")
                .bodyPartType(BodyPartType.CHEST)
                .exerciseDescription("Description")
                .build());

        exerciseRepository.save(Exercise.builder()
                .name("Deadlifting")
                .bodyPartType(BodyPartType.LEGS)
                .exerciseDescription("Description")
                .build());
    }
}