package br.com.homework.superheroes.api.dtos;


import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperHeroResponseDTO {

    public SuperHeroDTO data;
}
