package com.desafio.agenda.entity;

import com.desafio.agenda.dto.EnderecoCreateRequest;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@EqualsAndHashCode
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua", length = 255)
    private String rua;

    @Column(name = "complemento", length = 255)
    private String complemento ;

    @Column(name = "bairro", length = 255)
    private String bairro;

    @Column(name = "numero", length = 5)
    private String numero;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "latitude", length = 30)
    private Double latitude;

    @Column(name = "longitude", length = 30)
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "cidade", nullable = false)
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
    }

    public Endereco(String complemento, Long id, String rua, String bairro,
                    String numero, String cep, Cidade cidade) {
        this.complemento = complemento;
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Endereco(EnderecoCreateRequest endereco) {
        BeanUtils.copyProperties(endereco, this);
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
