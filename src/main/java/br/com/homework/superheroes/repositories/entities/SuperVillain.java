package br.com.homework.superheroes.repositories.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SuperVillain extends SuperPerson{

    private SuperHero archNemesis;

}
