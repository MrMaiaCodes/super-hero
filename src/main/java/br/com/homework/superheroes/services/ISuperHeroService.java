package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.Guild;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.repositories.entities.SuperVillain;

public interface ISuperHeroService extends IServiceSuperPerson<SuperHero>{

    SuperHero findSuperHeroByName(String name);

    void addARchNemesis(String heroName, String villainName);

    void addGuild(String heroName, String guildName);


}
