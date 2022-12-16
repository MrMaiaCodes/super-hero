package br.com.homework.superheroes.repository.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperVillain extends SuperPerson{

    private SuperVillain archNemesis;

}
