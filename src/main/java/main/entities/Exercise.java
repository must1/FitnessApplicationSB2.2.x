package main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
