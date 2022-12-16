package br.com.homework.superheroes.repository.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperPerson {

    private String name;

    private String alias;

    private int age;

    private List<SuperPower> superPower;
}
