package main.entity;

import lombok.*;
import main.product.ProductType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    private double fatNumber;
    private double proteinNumber;
    private ProductType type;
    private double carbohydratesNumber;
    private int kcalNumber;
}
