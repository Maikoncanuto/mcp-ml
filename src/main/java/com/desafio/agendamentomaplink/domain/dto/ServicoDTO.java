package com.desafio.agendamentomaplink.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO implements BaseDTO {

    private Long id;
    private String codigo;
    private String descricao;
    private String valor;
}
