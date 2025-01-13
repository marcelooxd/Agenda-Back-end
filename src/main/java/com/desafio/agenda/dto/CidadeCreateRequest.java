package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Cidade;
import com.desafio.agenda.entity.EEstado;
import com.desafio.agenda.entity.Endereco;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@EqualsAndHashCode
public class CidadeCreateRequest {

    private Long id;
    private String cidade;
    private EEstado estado;

    public CidadeCreateRequest(Cidade cidade) {
        BeanUtils.copyProperties(cidade, this);
    }
    public CidadeCreateRequest() {}

    public Long getId() {
        return id;
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
