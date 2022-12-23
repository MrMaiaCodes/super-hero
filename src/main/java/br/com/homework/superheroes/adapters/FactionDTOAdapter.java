package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.FactionDTO;
import br.com.homework.superheroes.repositories.entities.Faction;

import java.util.List;

public class FactionDTOAdapter {


    public static FactionDTO convertTo(Faction faction) {

        FactionDTO factionDTO = new FactionDTO();

        factionDTO.setName(faction.getName());
        factionDTO.setHeadQuarters(faction.getHeadQuarters());

        return factionDTO;
    }

    public static List<FactionDTO> convertToList(List<Faction> factionList) {
        return factionList.stream().map(item -> convertTo(item)).toList();
    }
}
