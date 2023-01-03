package br.com.homework.superheroes.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class villainsNewArchNemesisDTO {

    private String villainName;

    private String nemesisName;
}
