package main.history;

import main.exercise.BodyPartType;
import main.model.user.User;
import main.model.user.UserHistory;
import main.userproduct.UserProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserHistoryServiceTest {

    private UserHistoryService userHistoryService;

    @Mock
    private UserProductRepository userProductRepository;

    @Test
    public void shouldReturnProperUserHistory() {
        //given
        userHistoryService = new UserHistoryService(userProductRepository);
        User user = createUser();
        UserHistory expectedUserHistory = UserHistory.builder()
                .carbohydratesNumber(20d)
                .fatNumber(20d)
                .kcalNumber(20d)
                .proteinNumber(20d)
                .dateOfEatenProduct(LocalDate.now())
                .build();

        when(userProductRepository.countCaloriesForDay(user.getId(), LocalDate.now())).thenReturn(20d);
        when(userProductRepository.countCarbohydratesForDay(user.getId(), LocalDate.now())).thenReturn(20d);
        when(userProductRepository.countFatForDay(user.getId(), LocalDate.now())).thenReturn(20d);
        when(userProductRepository.countProteinsForDay(user.getId(), LocalDate.now())).thenReturn(20d);

        //when
        UserHistory actualUserHistory = userHistoryService.getUserHistory(user, LocalDate.now());

        //then
        assertEquals(expectedUserHistory, actualUserHistory);
    }

    private User createUser() {
        return User.builder()
                .firstName("Macko")
                .lastName("Bogdaniec")
                .username("must1")
                .email("penetrat@gmail.com")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .phoneNumber("213702137")
                .favouriteBodyPartType(BodyPartType.CHEST)
                .build();
    }
}