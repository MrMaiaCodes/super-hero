package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperHeroRepository;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.services.AbstractValidateService;
import br.com.homework.superheroes.services.ISuperHeroService;
import br.com.homework.superheroes.services.ISuperPowerService;
import br.com.homework.superheroes.services.ISuperVillainService;
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


    @Override
    public SuperHero save(SuperHero superHero){

        if(validate(superHero)){
            superHeroRepository.save(superHero);
            return superHero;
        } else
            return null;

    }

    public SuperHero findSuperHeroByName(String name){
        var superHeroFind = superHeroRepository.findSuperHeroByName(name);
        if (superHeroFind != null){
            return superHeroFind;
        }
        else {
            System.out.println("Hero not found!");
        }
        return null;
    }

    @Override
    public void addARchNemesis(String heroName, String villainName) {

        var heroFind = findSuperHeroByName(heroName);
        var villainFind = superVillainService.findSuperVillainByName(villainName);

        if (heroFind != null && villainFind != null) {
            if (heroFind.getArchNemesis() != null)
                heroFind.setArchNemesis(villainFind);

            villainFind.setArchNemesis(heroFind);
        }
    }

    @Override
    public List<SuperHero> listAll(){
        return superHeroRepository.listAll();
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return null;
    }


    @Override
    public void delete (SuperHero superHero){

    }

    @Override
    protected boolean validate(SuperHero superHero) {
        return !validateStringIsNullOrBlank(superHero.getName())
                && validateIntNotZero(superHero.getAge());
    }

    @Override
    public void addSuperPower(String personName, String superPowerName) {
        var superHeroFind = findSuperHeroByName(personName);
        var superPowerFind = superPowerService.findSuperPowerByName(superPowerName);

        if (superHeroFind != null && superPowerFind != null){
            if (superHeroFind.getSuperPower() != null)
                superHeroFind.setSuperPower(new ArrayList<>());
            superHeroFind.getSuperPower().add(superPowerFind);
        }
    }
}
