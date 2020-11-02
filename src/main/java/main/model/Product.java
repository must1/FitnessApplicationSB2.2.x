package main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import main.product.ProductType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "product_entity")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;
    @Column(name = "kcal_number_per100g")
    private double kcalNumberPer100G;
    @Column(name = "fat_number_per100g")
    private double fatNumberPer100G;
    @Column(name = "protein_number_per100g")
    private double proteinNumberPer100G;
    @Column(name = "carbohydrates_number_per100g")
    private double carbohydratesNumberPer100G;
}
