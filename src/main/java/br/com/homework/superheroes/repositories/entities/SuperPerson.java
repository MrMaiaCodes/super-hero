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

    private List<SuperPower> superPower = new ArrayList<>();
}
