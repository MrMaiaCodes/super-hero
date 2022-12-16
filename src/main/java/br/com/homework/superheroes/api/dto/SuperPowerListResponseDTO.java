package br.com.homework.superheroes.api.dto;

import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.repository.model.SuperPower;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperPowerListResponseDTO {

    public List<SuperPower> data;
}
