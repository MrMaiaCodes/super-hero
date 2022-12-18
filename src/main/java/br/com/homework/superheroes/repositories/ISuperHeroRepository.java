package br.com.homework.superheroes.repositories;

import br.com.homework.superheroes.repositories.entities.SuperHero;

public interface ISuperHeroRepository extends IRepository<SuperHero>{


    SuperHero findSuperHeroByName(String name);

}
