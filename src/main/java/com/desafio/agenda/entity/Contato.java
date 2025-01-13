package com.desafio.agenda.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Calendar;


@Entity
@Table(name = "contatos")
@EqualsAndHashCode
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_nome", length = 100, nullable = false)
    private String primeiroNome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "cpfCnpj", length = 14, nullable = false)
    private String cpfCnpj;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_aniversario", nullable = false)
    private Calendar dataAniversario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", length = 12, nullable = false)
    private String telefone;

    @Column(name = "profissao")
    private String profissao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa")
    private ETipoPessoa tipoPessoa = ETipoPessoa.FISICA;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private EGenero genero;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Contato() {
    }

    public Contato(Long id) {
        this.id = id;
    }

    public Contato(Long id, String primeiroNome, String sobrenome, String cpfCnpj,
                   Calendar dataAniversario, String email, String telefone, String profissao,
                   ETipoPessoa tipoPessoa, Endereco endereco, EGenero genero) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.dataAniversario = dataAniversario;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.tipoPessoa = tipoPessoa;
        this.endereco = endereco;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
