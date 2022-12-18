package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperVillainRepository;
import br.com.homework.superheroes.repositories.entities.SuperVillain;
import br.com.homework.superheroes.services.AbstractValidateService;
import br.com.homework.superheroes.services.ISuperPowerService;
import br.com.homework.superheroes.services.ISuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperVillainService extends AbstractValidateService<SuperVillain> implements ISuperVillainService {

    @Autowired
    private ISuperVillainRepository superVillainRepository;

    @Autowired
    private ISuperPowerService superPowerService;


    @Override
    public SuperVillain save(SuperVillain superVillain) {


        if (validate(superVillain)){
            superVillainRepository.save(superVillain);
            return superVillain;
        } else {
            return null;
        }
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

        var superVillainFind = superVillainRepository
                .findSuperVillainByName(superVillainName);
        if (superVillainFind != null) {
            return superVillainFind;
        }
        else {
            System.out.println("Villain not found!");
        }
        return null;
    }

    @Override
    protected boolean validate(SuperVillain superVillain) {

        return !validateStringIsNullOrBlank(superVillain.getName())
                && validateIntNotZero(superVillain.getAge());

    }
}
