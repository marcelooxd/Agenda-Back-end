package com.desafio.agenda.entity;

public enum ETipoPessoa {

   JURIDICA("Jurídica"),
   FISICA("Física");

   private final String tipo;

   ETipoPessoa(String tipo) {
      this.tipo = tipo;
   }

   public String getTipo() {
      return tipo;
   }
}