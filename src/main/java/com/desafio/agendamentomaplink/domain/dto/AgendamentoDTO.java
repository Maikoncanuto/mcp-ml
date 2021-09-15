package com.desafio.agendamentomaplink.domain.dto;

import com.desafio.agendamentomaplink.domain.model.Cliente;
import com.desafio.agendamentomaplink.domain.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO implements BaseDTO {

    private LocalDateTime dataHora;
    private String observacao;
    private Cliente cliente;
    private Servico servico;
}
