package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.api.dtos.requests.SuperPowerDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperPowerResponseDTO {

    public SuperPowerDTO data;
}


