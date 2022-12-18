package br.com.homework.superheroes.api.dtos.requests;

import br.com.homework.superheroes.repositories.entities.SuperPower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperHeroDTO {

    private String name;

    private String alias;

    private int age;

    private List<SuperPowerDTO> superPower;

}
