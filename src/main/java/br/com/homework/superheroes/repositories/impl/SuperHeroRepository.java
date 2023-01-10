package br.com.homework.superheroes.repositories.impl;

import br.com.homework.superheroes.repositories.ISuperHeroRepository;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperHeroRepository implements ISuperHeroRepository {

    private List<SuperHero> superHeroes = new ArrayList<>();

    @Override
    public SuperHero save(SuperHero superHero){
        superHeroes.add(superHero);
        return superHero;
    }

    @Override
    public void delete(SuperHero superHero) {

        superHeroes.remove(superHero);

    }

    public SuperHero findSuperHeroByName(String name){
        for (SuperHero superHeroFind : superHeroes){
            if (superHeroFind.getName().equalsIgnoreCase(name)){
                return superHeroFind;
            }
        }
        return null;
    }

    @Override
    public List<SuperHero> listAll() {
        return superHeroes;
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return null;
    }
}


