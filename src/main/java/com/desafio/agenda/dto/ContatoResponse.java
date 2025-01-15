package com.desafio.agenda.dto;

import com.desafio.agenda.entity.*;
import org.springframework.beans.BeanUtils;

import java.util.Calendar;

public class ContatoResponse {

    private Long id;
    private String primeiroNome;
    private String sobrenome;
    private String cpfCnpj;
    private Calendar dataAniversario;
    private String email;
    private String telefone;
    private String profissao;
    private ETipoPessoa tipoPessoa;
    private EGenero genero;
    private EnderecoResponse endereco;
    private Long usuario;

    public ContatoResponse() {}

    public ContatoResponse(Contato contato) {
        this.id = contato.getId();
        this.primeiroNome = contato.getPrimeiroNome();
        this.sobrenome = contato.getSobrenome();
        this.cpfCnpj = contato.getCpfCnpj();
        this.dataAniversario = contato.getDataAniversario();
        this.email = contato.getEmail();
        this.telefone = contato.getTelefone();
        this.profissao = contato.getProfissao();
        this.tipoPessoa = contato.getTipoPessoa();
        this.genero = contato.getGenero();
        this.endereco = new EnderecoResponse(contato.getEndereco());
        this.usuario = contato.getUsuario().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public ETipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(ETipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public EGenero getGenero() {
        return genero;
    }

    public void setGenero(EGenero genero) {
        this.genero = genero;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public EnderecoResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponse endereco) {
        this.endereco = endereco;
    }
}
