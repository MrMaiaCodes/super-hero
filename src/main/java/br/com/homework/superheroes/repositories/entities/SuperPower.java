package br.com.homework.superheroes.repositories.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperPower {

    private String description;

    private String type;

    private int powerLevel;
}
