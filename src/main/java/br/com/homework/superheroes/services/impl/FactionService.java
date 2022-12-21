package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.entities.Faction;
import br.com.homework.superheroes.services.IFactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactionService implements IFactionService {
    @Override
    public Faction findFactionByName(String factionName) {
        return null;
    }

    @Override
    public Faction save(Faction faction) {
        return null;
    }

    @Override
    public void delete(Faction faction) {

    }

    @Override
    public List<Faction> listAll() {
        return null;
    }

    @Override
    public Faction update(Faction faction) {
        return null;
    }
}
