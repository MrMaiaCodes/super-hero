package br.com.homework.superheroes.api.dto;

import br.com.homework.superheroes.repository.model.SuperHero;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperHeroListResponseDTO {

    public List<SuperHero> data;
}
