package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.SuperHero;

public interface ISuperHeroService extends IServiceSuperPerson<SuperHero>{

    SuperHero findSuperHeroByName(String name);

    void addArchNemesis(String heroName, String villainName);

    void addGuild(String heroName, String guildName);


}
