package br.com.homework.superheroes.service.impl;

import br.com.homework.superheroes.repository.model.SuperPower;
import br.com.homework.superheroes.service.AbstractValidateService;
import br.com.homework.superheroes.service.ISuperPowerService;

public class SuperPowerService extends AbstractValidateService<SuperPower> implements ISuperPowerService {

    @Override
    public SuperPower superPowerSaver(String name, String type) {
        return SuperPower.builder()
                .powerName(name)
                .type(type)
                .build();
    }

    @Override
    protected boolean validate(SuperPower superPower) {
        return validateStringIsNullOrBlank(superPower.getPowerName());
    }
}
