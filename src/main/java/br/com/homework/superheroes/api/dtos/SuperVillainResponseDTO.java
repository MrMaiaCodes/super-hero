package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.api.dtos.requests.SuperVillainDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperVillainResponseDTO {

    public SuperVillainDTO data;
}
