package br.com.homework.superheroes.service.impl;

import br.com.homework.superheroes.repository.ISuperVillainRepository;
import br.com.homework.superheroes.repository.model.SuperVillain;
import br.com.homework.superheroes.service.ISuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SuperVillainService implements ISuperVillainService {

    @Autowired
    private ISuperVillainRepository superVillainRepository;


    @Override
    public SuperVillain save(SuperVillain superVillain) {
        return superVillain;
    }

    @Override
    public void delete(SuperVillain superVillain) {

    }

    @Override
    public List<SuperVillain> listAll() {
        return superVillainRepository.listAll();
    }

    @Override
    public SuperVillain update(SuperVillain superVillain) {
        return null;
    }

    @Override
    public SuperVillain findSuperVillainByName(String superVillainName) {
        return null;
    }
}
