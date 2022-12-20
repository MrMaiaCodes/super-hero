package br.com.homework.superheroes.repositories;

import br.com.homework.superheroes.repositories.entities.Faction;

public interface IFactionRepository extends IRepository<Faction>{

    Faction findFactionByName(String factionName);
}
