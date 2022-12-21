package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.Faction;

public interface IFactionService extends IService<Faction>{

    Faction findFactionByName (String factionName);
}
