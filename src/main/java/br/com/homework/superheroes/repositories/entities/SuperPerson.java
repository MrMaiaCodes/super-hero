package br.com.homework.superheroes.repositories.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
public class SuperPerson {

    private String name;

    private String alias;

    private int age;

    private int strength;

    private int agility;

    private int intelligence;

    private int experience;

    private int level;

    private List<SuperPower> superPower = new ArrayList<>();
}
