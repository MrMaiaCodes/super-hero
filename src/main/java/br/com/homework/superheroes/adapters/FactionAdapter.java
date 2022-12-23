package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.FactionDTO;
import br.com.homework.superheroes.repositories.entities.Faction;

import java.util.List;

public class FactionAdapter {


    public static Faction convertTo(FactionDTO factionDTO){
        return Faction.builder()
                .name(factionDTO.getName())
                .headQuarters(factionDTO.getHeadQuarters())
                .build();
    }

    public static List<Faction> convertToList(List<FactionDTO> factionDTO) {
        return factionDTO.stream().map(item -> convertTo(item)).toList();
    }
}
