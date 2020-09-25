package com.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MunicipiosDTO {
    private String id;
    private String nome;
    private MicrorregiaoDTO microrregiaoa;

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

    public MicrorregiaoDTO getMicrorregiao() {
        return microrregiaoa;
    }

    public void setMicrorregiao(MicrorregiaoDTO microrregiaoa) {
        this.microrregiaoa = microrregiaoa;
    }
}
