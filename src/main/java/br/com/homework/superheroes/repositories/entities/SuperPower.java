package br.com.homework.superheroes.repositories.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperPower {

    private String name;

    private String type;

    private int powerLevel;

    private int strengthRequirement;

    private int agilityRequirement;

    private int intelligenceRequirement;

    private int luckRequirement;
}
