package br.com.homework.superheroes.api.dtos;

import br.com.homework.superheroes.api.dtos.requests.SuperVillainDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SuperVillainListResponseDTO {

    public List<SuperVillainDTO> data;
}
