package br.com.homework.superheroes.repository;

import br.com.homework.superheroes.repository.model.SuperHero;

import java.util.List;

public interface ISuperHeroRepository extends IRepository<SuperHero>{


    SuperHero findSuperHeroByName(String name);

}
