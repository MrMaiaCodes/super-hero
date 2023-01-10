package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperHeroRepository;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperHeroService extends AbstractValidateService<SuperHero> implements ISuperHeroService {

    @Autowired
    private ISuperHeroRepository superHeroRepository;

    @Autowired
    private ISuperPowerService superPowerService;

    @Autowired
    private ISuperVillainService superVillainService;

    @Autowired
    private IGuildService guildService;


    @Override
    public SuperHero save(SuperHero superHero) {

        if (validate(superHero) && ((superHero.getStrength()
                + superHero.getAgility()
                + superHero.getIntelligence()) <= 30)) {
            superHeroRepository.save(superHero);
            return superHero;
        } else
            return null;

    }

    public SuperHero findSuperHeroByName(String name) {
        var superHeroFind = superHeroRepository.findSuperHeroByName(name);
        if (superHeroFind != null) {
            return superHeroFind;
        } else {
            System.out.println("Hero not found!");
        }
        return null;
    }

    @Override
    public void addArchNemesis(String heroName, String villainName) {

        var heroFind = findSuperHeroByName(heroName);
        var villainFind = superVillainService.findSuperVillainByName(villainName);

        if (heroFind != null && villainFind != null) {
            heroFind.setArchNemesis(villainFind);
            villainFind.setArchNemesis(heroFind);
        }
    }

    @Override
    public void addGuild(String heroName, String guildName) {

        var heroFind = findSuperHeroByName(heroName);
        var guildFind = guildService.findGuildByName(guildName);
        if (heroFind != null && guildFind != null) {
            if  (guildFind.getMemberList() == null)
                guildFind.setMemberList(new ArrayList<>());
            heroFind.setGuild(guildFind);
            guildFind.getMemberList().add(heroFind);
            guildFind.setNumberOfMembers(guildFind.getNumberOfMembers() + 1);
        }
    }

    @Override
    public List<SuperHero> listAll() {
        return superHeroRepository.listAll();
    }

    @Override
    public SuperHero update(SuperHero superHero) {

        var superHeroFind = superHeroRepository.findSuperHeroByName(superHero.getName());
        superHeroFind.setName(superHero.getName());
        superHeroFind.setAlias(superHero.getAlias());
        superHeroFind.setAge(superHero.getAge());
        superHeroFind.setSuperPowers(superHero.getSuperPowers());
        superHeroFind.setStrength(superHero.getStrength());
        superHeroFind.setAgility(superHero.getAgility());
        superHeroFind.setIntelligence(superHero.getIntelligence());
        superHeroFind.setExperience(superHero.getExperience());
        superHeroFind.setLuck(superHero.getLuck());
        superHeroFind.setLevel(superHero.getLevel());
        superHeroFind.setGuild(superHero.getGuild());

        return null;
    }


    @Override
    public void delete(SuperHero superHero) {

    }

    @Override
    protected boolean validate(SuperHero superHero) {
        return !validateStringIsNullOrBlank(superHero.getName())
                && validateLongNotZero(superHero.getAge());
    }

    @Override
    public void addSuperPower(String personName, String superPowerName) {
        var superHeroFind = findSuperHeroByName(personName);
        var superPowerFind = superPowerService.findSuperPowerByName(superPowerName);

        if (superHeroFind != null && superPowerFind != null
                && superPowerFind.getStrengthRequirement() <= superHeroFind.getStrength()
                && superPowerFind.getAgilityRequirement() <= superHeroFind.getAgility()
                && superPowerFind.getIntelligenceRequirement() <= superHeroFind.getIntelligence()
                && superPowerFind.getLuckRequirement() <= superHeroFind.getLuck()) {
            if (superHeroFind.getSuperPowers() == null)
                superHeroFind.setSuperPowers(new ArrayList<>());
            superHeroFind.getSuperPowers().add(superPowerFind);
        }
    }
}
