package br.com.homework.superheroes.repository.impl;

import br.com.homework.superheroes.repository.ISuperHeroRepository;
import br.com.homework.superheroes.repository.model.SuperHero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperHeroRepository implements ISuperHeroRepository {

    private List<SuperHero> superHeroes = new ArrayList<>();

    private static SuperHeroRepository instance;

    public SuperHeroRepository(){}

    public static SuperHeroRepository getInstance(){
        if (instance == null){
            instance = new SuperHeroRepository();
        }
        return instance;
    }

    public void superHeroSave(SuperHero superHero){
        superHeroes.add(superHero);
    }

    public SuperHero findSuperHeroByName(String name){
        for (SuperHero superHeroFind : superHeroes){
            if (superHeroFind.getName().equalsIgnoreCase(name)){
                return superHeroFind;
            }
        }
        return null;
    }

    public List<SuperHero> listAllSuperHeroes() {
        return superHeroes;
    }
}


