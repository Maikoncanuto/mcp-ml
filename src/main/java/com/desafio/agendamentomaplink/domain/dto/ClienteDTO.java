package com.desafio.agendamentomaplink.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements BaseDTO {

    private String nome;
    private String cpf;
}
