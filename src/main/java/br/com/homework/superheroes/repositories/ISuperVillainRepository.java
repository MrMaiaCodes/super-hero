package br.com.homework.superheroes.repositories;

import br.com.homework.superheroes.repositories.entities.SuperVillain;

public interface ISuperVillainRepository extends IRepository<SuperVillain> {

    SuperVillain findSuperVillainByName(String superVillain);

}
