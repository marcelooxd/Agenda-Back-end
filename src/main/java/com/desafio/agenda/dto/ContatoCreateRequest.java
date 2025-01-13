package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Contato;
import com.desafio.agenda.entity.EGenero;
import com.desafio.agenda.entity.ETipoPessoa;

import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.util.Calendar;

@EqualsAndHashCode
public class ContatoCreateRequest {

    private String primeiroNome;
    private String sobrenome;
    private String cpfCnpj;
    private Calendar dataAniversario;
    private String email;
    private String telefone;
    private String profissao;
    private ETipoPessoa tipoPessoa;
    private EGenero genero;
    private Long usuario;
    private EnderecoCreateRequest endereco;

    public ContatoCreateRequest() {}

    public ContatoCreateRequest(Contato contato) {
        BeanUtils.copyProperties(contato, this);
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Calendar getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Calendar dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ETipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(ETipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public EGenero getGenero() {
        return genero;
    }

    public void setGenero(EGenero genero) {
        this.genero = genero;
    }

    public EnderecoCreateRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCreateRequest endereco) {
        this.endereco = endereco;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}
