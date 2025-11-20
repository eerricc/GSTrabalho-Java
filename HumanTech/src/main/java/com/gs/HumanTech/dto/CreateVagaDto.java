package com.gs.HumanTech.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateVagaDto {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Tipo de trabalho é obrigatório")
    private String tipoTrabalho;

    @NotBlank(message = "Salário é obrigatório")
    private Float salario;

    private String descricao;
}