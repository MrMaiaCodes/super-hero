package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.IFactionRepository;
import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.Faction;
import br.com.homework.superheroes.services.AbstractValidateService;
import br.com.homework.superheroes.services.IFactionService;
import br.com.homework.superheroes.services.ISuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactionService extends AbstractValidateService<Faction> implements IFactionService {

    @Autowired
    private IFactionRepository factionRepository;

    @Autowired
    private ISuperVillainService superVillainService;

    @Override
    public Faction findFactionByName(String factionName) {

        var factionFind = factionRepository.findFactionByName(factionName);
        if (factionFind != null) {
            return factionFind;
        } else {
            System.out.println("Faction not found!");
        }
        return null;
    }

    @Override
    public Faction save(Faction faction) {
        if (validate(faction)) {
            factionRepository.save(faction);
            return faction;
        } else {
            return null;
        }

    }

    @Override
    public void delete(Faction faction) {

    }

    @Override
    public List<Faction> listAll() {
        return factionRepository.listAll();
    }

    @Override
    public Faction update(Faction faction) {
        return null;
    }

    @Override
    protected boolean validate(Faction faction) {
        return !validateStringIsNullOrBlank(faction.getName())
                && validateIntNotZero(faction.getNumberOfMembers());
    }
}
