package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.GuildDTO;
import br.com.homework.superheroes.repositories.entities.Guild;

import java.util.List;

public class GuildAdapter {


    public static Guild convertTo(GuildDTO guildDTO) {
        return Guild.builder()
                .name(guildDTO.getName())
                .headQuarters(guildDTO.getHeadQuarters())
                .build();
    }

    public static List<Guild> convertToList(List<GuildDTO> guildDTOList) {
        return guildDTOList.stream().map(item -> convertTo(item)).toList();
    }
}
