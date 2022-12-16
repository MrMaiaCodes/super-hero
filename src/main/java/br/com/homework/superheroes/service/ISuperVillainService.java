package br.com.homework.superheroes.service;

import br.com.homework.superheroes.repository.model.SuperVillain;

public interface ISuperVillainService extends IService<SuperVillain>{

    SuperVillain findSuperVillainByName(String superVillainName);
}
