package com.gs.HumanTech.model;

import lombok.Data;

@Data
public class VagaModel {
    private Integer id_vaga;
    private String titulo;
    private String tipo_trabalho;
    private Float salario;
    private String descricao;

    public VagaModel() {}

    public VagaModel(Integer id_vaga, String titulo, String tipo_trabalho,
                     Float salario, String descricao){

        this.id_vaga = id_vaga;
        this.titulo = titulo;
        this.tipo_trabalho = tipo_trabalho;
        this.salario = salario;
        this.descricao = descricao;
    }
}
