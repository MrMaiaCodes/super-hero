package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperVillainDTO;
import br.com.homework.superheroes.repositories.entities.SuperVillain;

import java.util.List;

public class SuperVillainAdapter {

    public static SuperVillain convertTo(SuperVillainDTO superVillainDTO){
        return SuperVillain.builder()
                .name(superVillainDTO.getName())
                .alias(superVillainDTO.getAlias())
                .age(superVillainDTO.getAge())
                .superPowers(SuperPowerAdapter.convertToList(superVillainDTO.getSuperPower()))
                .build();
    }

    public static List<SuperVillain> convertToList(List<SuperVillainDTO> superVillainDTO){
        return superVillainDTO.stream().map(item->convertTo(item)).toList();
    }
}
