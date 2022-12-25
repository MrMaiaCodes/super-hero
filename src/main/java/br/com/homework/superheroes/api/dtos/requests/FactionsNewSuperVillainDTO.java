package br.com.homework.superheroes.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactionsNewSuperVillainDTO {

    private String factionName;

    private String villainName;
}
