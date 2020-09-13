package main.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserHistory {

    private double fatNumber;
    private double proteinNumber;
    private double carbohydratesNumber;
    private double kcalNumber;
    private LocalDate dateOfEatenProduct;
}
