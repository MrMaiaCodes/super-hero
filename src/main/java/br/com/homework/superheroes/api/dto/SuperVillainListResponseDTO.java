package br.com.homework.superheroes.api.dto;

import br.com.homework.superheroes.repository.model.SuperVillain;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SuperVillainListResponseDTO {

    public List<SuperVillain> data;
}
