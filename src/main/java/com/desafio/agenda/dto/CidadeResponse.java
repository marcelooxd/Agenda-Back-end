package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Cidade;
import com.desafio.agenda.entity.EEstado;
import com.desafio.agenda.entity.Endereco;

public class CidadeResponse {

    private Long id;
    private String cidade;
    private EEstado estado;

    public CidadeResponse() {}

    public CidadeResponse(Long id, String cidade, EEstado estado) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
    }

    public CidadeResponse(Cidade cidade) {
        this.id = cidade.getId();
        this.cidade = cidade.getCidade();
        this.estado = cidade.getEstado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EEstado getEstado() {
        return estado;
    }

    public void setEstado(EEstado estado) {
        this.estado = estado;
    }
}
