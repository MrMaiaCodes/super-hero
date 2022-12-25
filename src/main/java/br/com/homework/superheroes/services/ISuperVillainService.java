package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.repositories.entities.SuperVillain;

public interface ISuperVillainService extends IService<SuperVillain>{

    SuperVillain findSuperVillainByName(String superVillainName);

    SuperHero addArchNemesis(String superHeroName);
}
