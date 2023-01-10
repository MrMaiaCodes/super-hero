package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.SuperVillain;
import br.com.homework.superheroes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperVillainService extends AbstractValidateService<SuperVillain> implements ISuperVillainService {

    @Autowired
    private ISuperVillainRepository superVillainRepository;

    @Autowired
    private ISuperPowerService superPowerService;

    @Autowired
    private IFactionService factionService;

    @Autowired
    private ISuperHeroService superHeroService;


    @Override
    public SuperVillain save(SuperVillain superVillain) {


        if (validate(superVillain) && ((superVillain.getStrength()
                + superVillain.getAgility()
                + superVillain.getIntelligence()) <= 30)) {
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

        var villainFind = superVillainRepository.findSuperVillainByName(
                superVillain.getName());
        villainFind.setName(superVillain.getName());
        villainFind.setAlias(superVillain.getAlias());
        villainFind.setAge(superVillain.getAge());
        villainFind.setFaction(superVillain.getFaction());
        villainFind.setStrength(superVillain.getStrength());
        villainFind.setAgility(superVillain.getAgility());
        villainFind.setIntelligence(superVillain.getIntelligence());
        villainFind.setLevel(superVillain.getLevel());
        villainFind.setKnowsHeroWeakness(superVillain.isKnowsHeroWeakness());

    return villainFind;
    }

    public void addSuperPower(String villainName, String powerName){
        var superVillainFind = findSuperVillainByName(villainName);
        var superPowerFind = superPowerService.findSuperPowerByName(powerName);

        if (superVillainFind != null && superPowerFind != null
                && superPowerFind.getStrengthRequirement() <= superVillainFind.getStrength()
                && superPowerFind.getAgilityRequirement() <= superVillainFind.getAgility()
                && superPowerFind.getIntelligenceRequirement() <= superVillainFind.getIntelligence()) {
            if (superVillainFind.getSuperPowers() == null)
                superVillainFind.setSuperPowers(new ArrayList<>());
            superVillainFind.getSuperPowers().add(superPowerFind);
        }
    }

    @Override
    public SuperVillain findSuperVillainByName(String superVillainName) {

        var superVillainFind = superVillainRepository
                .findSuperVillainByName(superVillainName);
        if (superVillainFind != null) {
            return superVillainFind;
        } else {
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
            if (factionFind.getMemberList() == null)
                factionFind.setMemberList(new ArrayList<>());
            villainFind.setFaction(factionFind);
            factionFind.getMemberList().add(villainFind);
            factionFind.setNumberOfMembers(factionFind.getNumberOfMembers() + 1);
        }
    }


    @Override
    protected boolean validate(SuperVillain superVillain) {

        return !validateStringIsNullOrBlank(superVillain.getName())
                && validateLongNotZero(superVillain.getAge());

    }

}
