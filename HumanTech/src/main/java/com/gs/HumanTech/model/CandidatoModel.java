package com.gs.HumanTech.model;

import lombok.Data;

@Data
public class CandidatoModel {

    private Integer id_candidato;
    private String nome;
    private String email;
    private String cidade;
    private String pais;

    public CandidatoModel(){}

    public CandidatoModel(Integer id_candidato, String nome, String email, String cidade, String pais) {

        this.id_candidato = id_candidato;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.pais = pais;
    }
}
