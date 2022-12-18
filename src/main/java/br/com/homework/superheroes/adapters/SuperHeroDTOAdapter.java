package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import br.com.homework.superheroes.repositories.entities.SuperHero;

import java.util.List;

public class SuperHeroDTOAdapter {

    public static SuperHeroDTO convertTo(SuperHero superHero){

        SuperHeroDTO superHeroDTO = new SuperHeroDTO();
        superHeroDTO.setName(superHero.getName());
        superHeroDTO.setAge(superHero.getAge());
        superHeroDTO.setAlias(superHero.getAlias());
        superHeroDTO.setSuperPower(SuperPowerDTOAdapter.convertToListDTO(superHero.getSuperPower()));

        return superHeroDTO;

    }

    public static List<SuperHeroDTO> convertToList(List<SuperHero> superHero){
        return superHero.stream().map(item->convertTo(item)).toList();
    }
}
