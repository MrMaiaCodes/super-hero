package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.repositories.entities.Faction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactionResponseDTO {

    public Faction data;
}
