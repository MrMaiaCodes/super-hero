package br.com.homework.superheroes.repository.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperPower {
    private String powerName;
    private String type;
}
