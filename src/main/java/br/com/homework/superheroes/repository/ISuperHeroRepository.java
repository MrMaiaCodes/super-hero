package br.com.homework.superheroes.repository;

import br.com.homework.superheroes.repository.model.SuperHero;

public interface ISuperHeroRepository {

    void superHeroSave(SuperHero superHero);

    SuperHero findSuperHeroByName(String name);
}
