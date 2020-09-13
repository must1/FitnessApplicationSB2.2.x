package main.model;

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
    private ProductType type;
    private double kcalNumberPer100G;
    private double fatNumberPer100G;
    private double proteinNumberPer100G;
    private double carbohydratesNumberPer100G;

}
