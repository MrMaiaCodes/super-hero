package br.com.homework.superheroes.repository;

import br.com.homework.superheroes.repository.model.SuperVillain;

public interface ISuperVillainRepository extends IRepository<SuperVillain> {

    SuperVillain findSuperVillainByName(String superVillain);

}
