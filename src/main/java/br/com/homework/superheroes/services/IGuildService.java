package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.Guild;

public interface IGuildService extends IService<Guild> {

    Guild findGuildByName(String guildName);

    void addSuperHero(String guildName, String heroName);
}
