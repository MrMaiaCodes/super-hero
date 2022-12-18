package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.api.dtos.requests.SuperPowerDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperPowerListResponseDTO {

    public List<SuperPowerDTO> data;
}
