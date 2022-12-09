package br.com.homework.superheroes.service.impl;

import br.com.homework.superheroes.repository.ISuperHeroRepository;
import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.repository.model.SuperPower;
import br.com.homework.superheroes.service.AbstractValidateService;
import br.com.homework.superheroes.service.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService extends AbstractValidateService<SuperHero> implements ISuperHeroService {

    @Autowired
    private ISuperHeroRepository superHeroRepository;


    public SuperHero superHeroSaver(String name, String alias, int age,
                                    List<SuperPower> superPower, double powerLevel){
        var superHero = SuperHero.builder()
                .name(name)
                .alias(alias)
                .age(age)
                .superPower(superPower)
                .powerLevel(powerLevel)
                .build();

        if(validate(superHero)){
            superHeroRepository.superHeroSave(superHero);
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

    public List<SuperHero> listAllSuperHeroes(){
        return superHeroRepository.listAllSuperHeroes();
    }

    public SuperHero changeSuperHeroInfo(String name, String alias, int age,
                                         List<SuperPower> superPower, double powerLevel){
        var superHeroToChange = superHeroRepository.findSuperHeroByName(name);

        superHeroToChange.setName(name);
        superHeroToChange.setAlias(alias);
        superHeroToChange.setAge(age);
        superHeroToChange.setSuperPower(superPower);
        superHeroToChange.setPowerLevel(powerLevel);

        superHeroRepository.superHeroSave(superHeroToChange);
        return superHeroToChange;
    }

    @Override
    protected boolean validate(SuperHero superHero) {
        return !validateStringIsNullOrBlank(superHero.getName())
                && validateIntNotZero(superHero.getAge());
    }
}
