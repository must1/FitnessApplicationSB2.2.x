package main.model.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_product_entity")
public class UserProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "user_id")
    private UUID userID;
    @Column(name = "name")
    private String name;
    @Column(name = "gram")
    private double gram;
    @Column(name = "fat_number")
    private double fatNumber;
    @Column(name = "protein_number")
    private double proteinNumber;
    @Column(name = "carbohydrates_number")
    private double carbohydratesNumber;
    @Column(name = "kcal_number")
    private double kcalNumber;
    @Column(name = "date_of_eaten_product")
    private LocalDate dateOfEatenProduct;
}