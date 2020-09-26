package com.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MicrorregiaoDTO {

    private String id;
    private String nome;
    private MesorregiaoDTO mesorregiao;

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

    public MesorregiaoDTO getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(MesorregiaoDTO mesorregiao) {
        this.mesorregiao = mesorregiao;
    }
}
