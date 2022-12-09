package br.com.homework.superheroes.service.impl;

import br.com.homework.superheroes.repository.ISuperHeroRepository;
import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.service.service.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService implements ISuperHeroService {

    @Autowired
    private ISuperHeroRepository superHeroRepository;


    public SuperHero superHeroSaver(String name, String alias, int age,
                                    String superPower, double powerLevel){
        SuperHero superHero = SuperHero.builder()
                .name(name)
                .alias(alias)
                .age(age)
                .superPower(superPower)
                .powerLevel(powerLevel)
                .build();

        superHeroRepository.superHeroSave(superHero);
        return superHero;
    }

    public SuperHero findSuperHeroByName(String name){
        SuperHero superHeroFind = superHeroRepository.findSuperHeroByName(name);
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
}
