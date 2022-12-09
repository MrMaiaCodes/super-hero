package br.com.homework.superheroes.service;

import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.repository.model.SuperPower;

import java.util.List;

public interface ISuperHeroService {

    public SuperHero superHeroSaver(String name, String alias, int age,
                                    List<SuperPower> superPower, double powerLevel);

    SuperHero findSuperHeroByName(String name);

    List<SuperHero> listAllSuperHeroes();

    SuperHero changeSuperHeroInfo(String name, String alias, int age,
                                  List<SuperPower> superPower, double powerLevel);
}
