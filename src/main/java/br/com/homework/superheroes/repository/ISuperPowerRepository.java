package br.com.homework.superheroes.repository;

import br.com.homework.superheroes.repository.model.SuperPower;

import java.util.List;

public interface ISuperPowerRepository extends IRepository<SuperPower>{

    SuperPower findSuperPowerByName(String name);

}
