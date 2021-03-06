package com.desafio.agendamentomaplink.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AttributeOverride(name = "id", column = @Column(name = "idAgendamento", unique = true, nullable = false, length = 4, precision = 10))
@Table(name = "TB_Agendamento")
public class Agendamento extends BaseEntity {

    @NotBlank
    @Column(name = "dataHora", length = 40, nullable = false)
    private LocalDateTime dataHora;

    @NotBlank
    @Column(name = "observacao", length = 250, nullable = false)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idServico", referencedColumnName = "idservico")
    private Servico servico;
}
