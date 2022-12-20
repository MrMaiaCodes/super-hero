package br.com.homework.superheroes.repositories;

import br.com.homework.superheroes.repositories.entities.Guild;

public interface IGuildRepository extends IRepository<Guild> {

    Guild findGuildByName (String guildName);
}
