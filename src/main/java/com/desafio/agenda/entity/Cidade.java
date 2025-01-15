package com.desafio.agenda.entity;

import com.desafio.agenda.dto.CidadeCreateRequest;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cidades")
@EqualsAndHashCode
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cidade", length = 255)
    private String cidade;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EEstado estado;

    public Cidade() {}

    public Cidade(Long id) {
        this.id = id;
    }

    public Cidade(Long id, String cidade, EEstado estado, List<Endereco> enderecos) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        this.enderecos = enderecos;
    }

    public Cidade(CidadeCreateRequest cidadeCreateRequest) {
        this.cidade = cidadeCreateRequest.getCidade();
        this.estado = cidadeCreateRequest.getEstado();
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public EEstado getEstado() {
        return estado;
    }

    public void setEstado(EEstado estado) {
        this.estado = estado;
    }
}
