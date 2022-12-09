package br.com.homework.superheroes.api.dto;


import br.com.homework.superheroes.repository.model.SuperHero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperHeroResponseDTO {

    public SuperHero data;
}
