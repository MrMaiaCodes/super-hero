package br.com.homework.superheroes.repository.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperHero {

    private String name;

    private String alias;

    private int age;

    private String superPower;

    private double powerLevel;
}
