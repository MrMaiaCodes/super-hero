package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.repositories.entities.Guild;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuildListResponseDTO {

    public List<Guild> data;
}
