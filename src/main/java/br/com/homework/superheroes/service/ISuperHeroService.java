package br.com.homework.superheroes.service;

import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.repository.model.SuperPower;

import java.util.List;

public interface ISuperHeroService extends IService<SuperHero>{

    SuperHero findSuperHeroByName(String name);


}
