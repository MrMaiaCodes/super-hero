package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperPowerDTO;
import br.com.homework.superheroes.repositories.entities.SuperPower;

import java.util.List;

public class SuperPowerAdapter {

    public static SuperPower convertTo(SuperPowerDTO superPowerDTO){
        return SuperPower.builder()
                .name(superPowerDTO.getDescription())
                .type(superPowerDTO.getType())
                .powerLevel(superPowerDTO.getPowerLevel())
                .build();
    }

    public static List<SuperPower> convertToList(List<SuperPowerDTO> superPowersDTO){
        return superPowersDTO.stream().map(item->convertTo(item)).toList();
    }
}
