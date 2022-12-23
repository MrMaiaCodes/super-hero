package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.repositories.entities.Faction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FactionListResponseDTO {

    public List<Faction> data;
}
