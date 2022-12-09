package br.com.homework.superheroes.service;

import br.com.homework.superheroes.repository.model.SuperPower;

public interface ISuperPowerService {
    SuperPower superPowerSaver(String name, String type);
}
