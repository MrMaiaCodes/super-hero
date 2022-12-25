package br.com.homework.superheroes.services;

import br.com.homework.superheroes.repositories.entities.SuperPerson;

public interface IServiceSuperPerson<T extends SuperPerson> extends IService<T> {

    void addSuperPower(String personName, String superPowerName);

}
