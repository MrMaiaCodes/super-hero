package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import br.com.homework.superheroes.repositories.entities.SuperHero;

import java.util.List;

public class SuperHeroAdapter {

    public static SuperHero convertTo(SuperHeroDTO superHeroDTO) {
        return SuperHero.builder()
                .name(superHeroDTO.getName())
                .alias(superHeroDTO.getAlias())
                .age(superHeroDTO.getAge())
                .superPowers(
                        superHeroDTO.getSuperPower() != null ?
                                SuperPowerAdapter.convertToList(superHeroDTO.getSuperPower()) :
                                List.of()
                )
                .build();
    }

    public static List<SuperHero> convertToList(List<SuperHeroDTO> superHeroDTO) {
        return superHeroDTO.stream().map(item -> convertTo(item)).toList();
    }
}
