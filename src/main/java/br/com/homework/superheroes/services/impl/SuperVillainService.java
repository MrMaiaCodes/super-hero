package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.SuperVillain;
import br.com.homework.superheroes.services.ISuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
