package com.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MesorregiaoDTO {

    private String id;
    private String nome;

    @JsonProperty("UF")
    private UFDTO UF;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UFDTO getUF() {
        return UF;
    }

    public void setUF(UFDTO UF) {
        this.UF = UF;
    }
}
