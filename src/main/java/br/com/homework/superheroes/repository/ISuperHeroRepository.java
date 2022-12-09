package br.com.homework.superheroes.repository;

import br.com.homework.superheroes.repository.model.SuperHero;

import java.util.List;

public interface ISuperHeroRepository {

    void superHeroSave(SuperHero superHero);

    SuperHero findSuperHeroByName(String name);

    List<SuperHero> listAllSuperHeroes();
}
