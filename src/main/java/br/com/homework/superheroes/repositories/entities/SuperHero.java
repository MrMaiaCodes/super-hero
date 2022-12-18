package br.com.homework.superheroes.repositories.entities;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SuperHero extends SuperPerson {

    private SuperVillain archNemesis;

}
