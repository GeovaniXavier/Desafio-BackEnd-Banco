package com.geovani.dsf.model;

import com.geovani.dsf.enuns.Type;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    @Column(unique = true)
    private String cpfOrCnpj;

    @Column(unique = true)
    private String email;

    private String senha;

    private Double saldo;
    private Type type;

    public Usuario() {
    }

    public Usuario(Long id, String nomeCompleto, String cpfOrCnpj, String email, String senha, Double saldo, Type type) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpfOrCnpj = cpfOrCnpj;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void acrescentarSaldo(Double valor) {
        saldo = saldo + valor;
    }

    public void removerSaldo(Double valor) {
        saldo = saldo - valor;
    }
}
