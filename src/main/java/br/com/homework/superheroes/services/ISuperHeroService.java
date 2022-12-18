package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.SuperHero;

public interface ISuperHeroService extends IService<SuperHero>{

    SuperHero findSuperHeroByName(String name);


}
