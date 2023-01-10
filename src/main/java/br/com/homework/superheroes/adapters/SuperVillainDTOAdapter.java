package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperVillainDTO;
import br.com.homework.superheroes.repositories.entities.SuperVillain;

import java.util.List;

public class SuperVillainDTOAdapter {

    public static SuperVillainDTO convertTo(SuperVillain superVillain){
        var superVillainDTO = new SuperVillainDTO();
        superVillainDTO.setName(superVillain.getName());
        superVillainDTO.setAge(superVillain.getAge());
        superVillainDTO.setAlias(superVillain.getAlias());
        superVillainDTO.setSuperPower(SuperPowerDTOAdapter.convertToListDTO(superVillain.getSuperPowers()));

        return superVillainDTO;

    }

    public static List<SuperVillainDTO> convertToList(List<SuperVillain> superVillains){
        return superVillains.stream().map(item->convertTo(item)).toList();
    }

}
