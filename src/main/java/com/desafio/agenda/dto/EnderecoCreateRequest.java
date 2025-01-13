package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Endereco;

import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
@EqualsAndHashCode
public class EnderecoCreateRequest {

    private Long id;
    private String rua;
    private String complemento ;
    private String bairro;
    private String numero;
    private String cep;
    private Double latitude;
    private Double longitude;
    private CidadeCreateRequest cidade;

    public EnderecoCreateRequest() {}

    public EnderecoCreateRequest(Endereco endereco) {
        BeanUtils.copyProperties(endereco, this);
    }

    public EnderecoCreateRequest(String rua, String complemento, String numero, String bairro,
                                 String cep, Double latitude, Double longitude, CidadeCreateRequest cidade) {
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cidade = cidade;
    }

    public CidadeCreateRequest getCidade() {
        return cidade;
    }

    public void setCidade(CidadeCreateRequest cidade) {
        this.cidade = cidade;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
