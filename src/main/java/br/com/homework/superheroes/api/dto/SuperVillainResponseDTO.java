package br.com.homework.superheroes.api.dto;

import br.com.homework.superheroes.repository.model.SuperVillain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperVillainResponseDTO {

    public SuperVillain data;
}
