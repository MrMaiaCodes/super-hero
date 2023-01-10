package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.ISuperPowerRepository;
import br.com.homework.superheroes.repositories.entities.SuperPower;
import br.com.homework.superheroes.services.AbstractValidateService;
import br.com.homework.superheroes.services.ISuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperPowerService extends AbstractValidateService<SuperPower> implements ISuperPowerService {


    @Autowired
    private ISuperPowerRepository superPowerRepository;

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
        return !validateStringIsNullOrBlank(superPower.getName());
    }

    @Override
    public SuperPower save(SuperPower superPower) {

        if(validate(superPower)) {
            superPowerRepository.save(superPower);
            return superPower;
        } else {
            return null;
        }
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

        var superPowerFind = superPowerRepository.findSuperPowerByName(superPower.getName());
        superPowerFind.setName(superPower.getName());
        superPowerFind.setType(superPower.getType());
        superPowerFind.setPowerLevel(superPower.getPowerLevel());
        superPowerFind.setStrengthRequirement(superPower.getStrengthRequirement());
        superPowerFind.setAgilityRequirement(superPower.getAgilityRequirement());
        superPowerFind.setIntelligenceRequirement(superPower.getIntelligenceRequirement());
        superPowerFind.setLuckRequirement(superPower.getLuckRequirement());

        return superPowerFind;
    }

}
