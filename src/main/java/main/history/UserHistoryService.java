package main.history;

import main.model.user.User;
import main.model.user.UserHistory;
import main.userproduct.UserProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserHistoryService {

    private final UserProductRepository userProductRepository;

    public UserHistoryService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    public UserHistory getUserHistory(User user, LocalDate localDate) {
        return UserHistory.builder()
                .carbohydratesNumber(userProductRepository.countCarbohydratesForDay(user.getId(), localDate))
                .proteinNumber(userProductRepository.countProteinsForDay(user.getId(), localDate))
                .fatNumber(userProductRepository.countFatForDay(user.getId(), localDate))
                .kcalNumber(userProductRepository.countCaloriesForDay(user.getId(), localDate))
                .dateOfEatenProduct(localDate)
                .build();
    }
}
