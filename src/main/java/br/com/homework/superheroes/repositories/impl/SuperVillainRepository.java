package br.com.homework.superheroes.repositories.impl;

import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.SuperVillain;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperVillainRepository implements ISuperVillainRepository {

    private List<SuperVillain> superVillains = new ArrayList<>();

    @Override
    public SuperVillain save(SuperVillain superVillain) {
        return null;
    }

    @Override
    public void delete(SuperVillain superVillain) {

    }

    @Override
    public List<SuperVillain> listAll() {
        return superVillains;
    }

    @Override
    public SuperVillain update(SuperVillain superVillain) {
        return null;
    }

    @Override
    public SuperVillain findSuperVillainByName(String superVillain) {
        return null;
    }
}
