package br.com.homework.superheroes.repositories.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Faction extends Group{

    private List<SuperVillain> memberList;
}
