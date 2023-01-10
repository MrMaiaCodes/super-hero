package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperPowerDTO;
import br.com.homework.superheroes.repositories.entities.SuperPower;

import java.util.List;

public class SuperPowerDTOAdapter {

    public static SuperPowerDTO convertTo(SuperPower superPower){
        var superPowerDTO = new SuperPowerDTO();
        superPowerDTO.setDescription(superPower.getName());
        superPowerDTO.setType(superPower.getType());
        superPowerDTO.setPowerLevel(superPower.getPowerLevel());

        return superPowerDTO;
    }

    public static List<SuperPowerDTO> convertToListDTO(List<SuperPower> superPowers){
        return superPowers.stream().map(item->convertTo(item)).toList();
    }
}
