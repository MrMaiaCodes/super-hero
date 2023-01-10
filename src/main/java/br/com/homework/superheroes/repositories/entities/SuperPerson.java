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

    private Long age;

    private Long strength;

    private Long agility;

    private Long intelligence;

    private Long experience;

    private Long level;

    private List<SuperPower> superPowers = new ArrayList<>();
}
