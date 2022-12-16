package br.com.homework.superheroes.repository.impl;

import br.com.homework.superheroes.repository.ISuperPowerRepository;
import br.com.homework.superheroes.repository.model.SuperPower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperPowerRepository implements ISuperPowerRepository {

    private List<SuperPower> superPowers = new ArrayList<>();


    public SuperPower findSuperPowerByName(String name) {
        for (SuperPower superPowerFind : superPowers) {
            if (superPowerFind.getDescription().equalsIgnoreCase(name)) {
                return superPowerFind;
            }
        }
        return null;
    }

    @Override
    public SuperPower save(SuperPower superPower) {
        return null;
    }

    @Override
    public void delete(SuperPower superPower) {

    }

    @Override
    public List<SuperPower> listAll() {
        return superPowers;
    }

    @Override
    public SuperPower update(SuperPower superPower) {
        return null;
    }
}
