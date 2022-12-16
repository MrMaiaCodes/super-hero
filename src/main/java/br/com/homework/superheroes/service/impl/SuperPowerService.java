package br.com.homework.superheroes.service.impl;

import br.com.homework.superheroes.repository.ISuperPowerRepository;
import br.com.homework.superheroes.repository.model.SuperPower;
import br.com.homework.superheroes.service.AbstractValidateService;
import br.com.homework.superheroes.service.ISuperHeroService;
import br.com.homework.superheroes.service.ISuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperPowerService extends AbstractValidateService<SuperPower> implements ISuperPowerService {


    @Autowired
    private ISuperPowerRepository superPowerRepository;

    @Autowired
    private ISuperHeroService superHeroService;


    public SuperPower findSuperPowerByName(String superPowerName) {
        var superPowerFind = superPowerRepository.findSuperPowerByName(superPowerName);
        if (superPowerFind != null) {
            return superPowerFind;
        } else {
            System.out.println("Power not found!");
        }
        return null;
    }


    @Override
    protected boolean validate(SuperPower superPower) {
        return validateStringIsNullOrBlank(superPower.getDescription());
    }

    @Override
    public SuperPower save(SuperPower superPower) {
        return superPower;
    }

    @Override
    public void delete(SuperPower superPower) {

    }

    @Override
    public List<SuperPower> listAll() {
        return superPowerRepository.listAll();
    }

    @Override
    public SuperPower update(SuperPower superPower) {
        return null;
    }

}
