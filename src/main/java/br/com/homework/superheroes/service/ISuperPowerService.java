package br.com.homework.superheroes.service;

import br.com.homework.superheroes.repository.model.SuperPower;

import java.util.List;

public interface ISuperPowerService extends IService<SuperPower>{



    SuperPower findSuperPowerByName(String superPowerName);




}
