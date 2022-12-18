package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.SuperPower;

public interface ISuperPowerService extends IService<SuperPower>{



    SuperPower findSuperPowerByName(String superPowerName);




}
