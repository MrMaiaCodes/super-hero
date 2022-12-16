package br.com.homework.superheroes.api.dto;

import br.com.homework.superheroes.repository.model.SuperPower;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperPowerResponseDTO {

    public SuperPower data;
}


