package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperHeroListResponseDTO {

    public List<SuperHeroDTO> data;
}
