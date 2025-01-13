package com.desafio.agenda.entity;

public enum EGenero {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String genero;

    EGenero(String genero) { this.genero = genero; }

    public String getGenero() { return genero; }
}
