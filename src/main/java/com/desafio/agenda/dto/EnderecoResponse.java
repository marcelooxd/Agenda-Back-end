package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Contato;
import com.desafio.agenda.entity.EGenero;
import com.desafio.agenda.entity.ETipoPessoa;
import com.desafio.agenda.entity.Endereco;
import jakarta.persistence.Column;

import java.util.Calendar;

public class EnderecoResponse {

    private Long id;
    private String rua;
    private String complemento ;
    private String bairro;
    private String numero;
    private String cep;
    private Double latitude;
    private Double longitude;
    private CidadeResponse cidade;

    public EnderecoResponse() {}

    public EnderecoResponse(Long id, String rua, String complemento,
                            String bairro, String numero, String cep,
                            Double latitude, Double longitude, CidadeResponse cidade) {
        this.id = id;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cidade = cidade;
    }

    public EnderecoResponse(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
        this.latitude = endereco.getLatitude();
        this.longitude = endereco.getLongitude();
        this.cidade = new CidadeResponse(endereco.getCidade());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public CidadeResponse getCidade() {
        return cidade;
    }

    public void setCidade(CidadeResponse cidade) {
        this.cidade = cidade;
    }



}
