package com.gs.HumanTech.dto;

import lombok.Data;

@Data
public class ResponseVagaDto {
    private Integer id_vaga;
    private String titulo;
    private String tipo_trabalho;
    private Float salario;
    private String descricao;
}
