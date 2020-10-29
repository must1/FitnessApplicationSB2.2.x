package main.userproduct;

import main.model.Product;
import main.model.user.User;
import main.model.user.UserProduct;
import main.product.ProductRepository;
import main.product.ProductType;
import main.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserProductServiceTest {

    private UserProductService userProductService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserProductRepository userProductRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    void shouldReturnProperNutrientsForGivenProduct() {
        userProductService = new UserProductService(userProductRepository, productRepository, userRepository);
        Product product = createProduct();
        UserProduct userProduct = createUserProduct();
        Map<String, Double> expectedValue = Map.of(
                "calculatedFat", 0.65,
                "calculatedProtein", 10.75,
                "calculatedCarbohydrates", 0d,
                "calculatedKcal", 49.5);

        when(userRepository.doesAccountExistsWithID(anyLong())).thenReturn(true);
        when(productRepository.findByName(anyString())).thenReturn(Optional.ofNullable(product));

        Map<String, Double> actualValue =
                userProductService.getNutrientsOfGivenProductAndAddItToEatenByHimToDB(userProduct, mock(User.class));

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @Test
    void shouldHasInteractionWithDB() {
        userProductService = new UserProductService(userProductRepository, productRepository, userRepository);
        Product product = createProduct();
        UserProduct userProduct = createUserProduct();

        when(userRepository.doesAccountExistsWithID(anyLong())).thenReturn(true);
        when(productRepository.findByName(anyString())).thenReturn(Optional.ofNullable(product));

        userProductService.getNutrientsOfGivenProductAndAddItToEatenByHimToDB(userProduct, mock(User.class));

        verify(userProductRepository, times(1)).save(any());
    }

    private Product createProduct() {
        return Product.builder()
                .name("Chicken")
                .carbohydratesNumberPer100G(0)
                .fatNumberPer100G(1.3)
                .proteinNumberPer100G(21.5)
                .kcalNumberPer100G(99)
                .type(ProductType.MEAT)
                .build();
    }

    private UserProduct createUserProduct() {
        return UserProduct.builder()
                .dateOfEatenProduct(LocalDate.now())
                .gram(50d)
                .name("Chicken")
                .build();
    }
}