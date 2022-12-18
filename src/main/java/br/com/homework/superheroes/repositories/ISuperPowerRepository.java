package br.com.homework.superheroes.repositories;

import br.com.homework.superheroes.repositories.entities.SuperPower;

public interface ISuperPowerRepository extends IRepository<SuperPower>{

    SuperPower findSuperPowerByName(String name);

}
