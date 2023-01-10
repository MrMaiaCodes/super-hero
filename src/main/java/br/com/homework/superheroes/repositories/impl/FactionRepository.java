package br.com.homework.superheroes.repositories.impl;

import br.com.homework.superheroes.repositories.IFactionRepository;
import br.com.homework.superheroes.repositories.entities.Faction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FactionRepository implements IFactionRepository {

    private List<Faction> factions = new ArrayList<>();


    @Override
    public Faction findFactionByName(String factionName) {
        for (Faction factionFind : factions){
            if (factionFind.getName().equalsIgnoreCase(factionName)){
                return factionFind;
            }
        }
        return null;
    }

    @Override
    public Faction save(Faction faction) {
        factions.add(faction);
        return faction;
    }

    @Override
    public void delete(Faction faction) {

        factions.remove(factions);

    }

    @Override
    public List<Faction> listAll() {
        return factions;
    }

    @Override
    public Faction update(Faction faction) {
        return null;
    }
}
