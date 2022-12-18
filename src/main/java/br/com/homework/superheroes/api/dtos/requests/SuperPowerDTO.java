package br.com.homework.superheroes.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperPowerDTO {

    private String description;

    private String type;

    private int powerLevel;

}
