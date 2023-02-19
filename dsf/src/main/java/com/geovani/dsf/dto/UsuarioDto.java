package com.geovani.dsf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geovani.dsf.enuns.Type;
import com.github.dozermapper.core.Mapping;

public class UsuarioDto {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String nomeCompleto;

    private String cpfOrCnpj;

    private String email;

    private String senha;

    private Double saldo;

    private Type type;

    public UsuarioDto() {

    }

    public UsuarioDto(Long key, String nomeCompleto, String cpfOrCnpj, String email, String senha, Double saldo, Type type) {
        this.key = key;
        this.nomeCompleto = nomeCompleto;
        this.cpfOrCnpj = cpfOrCnpj;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.type = type;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
}
