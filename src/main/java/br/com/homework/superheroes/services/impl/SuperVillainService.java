package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.repositories.entities.SuperVillain;
import br.com.homework.superheroes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperVillainService extends AbstractValidateService<SuperVillain> implements ISuperVillainService {

    @Autowired
    private ISuperVillainRepository superVillainRepository;

    @Autowired
    private ISuperPowerService superPowerService;

    @Autowired
    private ISuperHeroService superHeroService;

    @Autowired
    private IFactionService factionService;


    @Override
    public SuperVillain save(SuperVillain superVillain) {


        if (validate(superVillain)){
            superVillainRepository.save(superVillain);
            return superVillain;
        } else {
            return null;
        }
    }

    @Override
    public void delete(SuperVillain superVillain) {

    }

    @Override
    public List<SuperVillain> listAll() {
        return superVillainRepository.listAll();
    }

    @Override
    public SuperVillain update(SuperVillain superVillain) {
        return null;
    }

    @Override
    public SuperVillain findSuperVillainByName(String superVillainName) {

        var superVillainFind = superVillainRepository
                .findSuperVillainByName(superVillainName);
        if (superVillainFind != null) {
            return superVillainFind;
        }
        else {
            System.out.println("Villain not found!");
        }
        return null;
    }

    @Override
    public void addArchNemesis(String villainName, String superHeroName) {

        var villainFind = findSuperVillainByName(villainName);
        var heroFind = superHeroService.findSuperHeroByName(superHeroName);

        if (villainFind != null && heroFind != null) {
            if (villainFind.getArchNemesis() != null) {
                villainFind.setArchNemesis(heroFind);
                heroFind.setArchNemesis(villainFind);
            }
        }

    }

    @Override
    public void addFaction(String villainName, String factionName) {

        var villainFind = findSuperVillainByName(villainName);
        var factionFind = factionService.findFactionByName(factionName);

        if (villainFind != null && factionFind != null) {
            villainFind.setFaction(factionFind);
            factionFind.getMemberList().add(villainFind);
            factionFind.setNumberOfMembers(factionFind.getNumberOfMembers() + 1);
        }
    }


    @Override
    protected boolean validate(SuperVillain superVillain) {

        return !validateStringIsNullOrBlank(superVillain.getName())
                && validateIntNotZero(superVillain.getAge());

    }
}
