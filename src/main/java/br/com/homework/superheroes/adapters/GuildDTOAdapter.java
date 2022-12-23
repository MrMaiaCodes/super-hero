package br.com.homework.superheroes.adapters;

import br.com.homework.superheroes.api.dtos.requests.GuildDTO;
import br.com.homework.superheroes.repositories.entities.Guild;

import java.util.List;

public class GuildDTOAdapter {


    public static GuildDTO convertTo(Guild guild) {
        GuildDTO guildDTO = new GuildDTO();

        guildDTO.setName(guild.getName());
        guildDTO.setHeadQuarters(guild.getHeadQuarters());

        return guildDTO;
    }

    public static List<GuildDTO> convertToList(List<Guild> guildList) {
        return guildList.stream().map(item -> convertTo(item)).toList();
    }

}
