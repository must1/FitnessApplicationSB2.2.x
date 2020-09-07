package main.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserProduct {

    @Id
    @GeneratedValue
    private long id;
    private long userID;
    private String name;
    private double gram;
    private double fatNumber;
    private double proteinNumber;
    private double carbohydratesNumber;
    private int kcalNumber;
    private LocalDate dateOfEatenProduct;
}
