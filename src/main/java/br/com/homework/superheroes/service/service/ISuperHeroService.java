package br.com.homework.superheroes.service.service;

import br.com.homework.superheroes.repository.model.SuperHero;

import java.util.List;

public interface ISuperHeroService {

    public SuperHero superHeroSaver(String name, String alias, int age,
                                    String superPower, double powerLevel);

    SuperHero findSuperHeroByName(String name);

    List<SuperHero> listAllSuperHeroes();
}
