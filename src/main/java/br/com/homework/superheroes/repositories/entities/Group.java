package br.com.homework.superheroes.repositories.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Group {

    private String name;

    private String headQuarters;

    private int numberOfMembers;
}
