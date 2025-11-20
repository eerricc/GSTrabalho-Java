package com.gs.HumanTech.dto;

import lombok.Data;

@Data
public class ResponseCandidatoDto {
    private Integer id_candidato;
    private String nome;
    private String email;
    private String cidade;
    private String pais;
}
