package com.desafio.agendamentomaplink.service;

import com.desafio.agendamentomaplink.domain.dto.AgendamentoDTO;
import com.desafio.agendamentomaplink.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class AgendamentoService extends BaseService {

    private final AgendamentoRepository agendamentoRepository;

    public List<AgendamentoDTO> findAll() {
        return agendamentoRepository.findAll()
                .stream().map(agendamento -> getConverter().map(agendamento, AgendamentoDTO.class))
                .collect(toList());
    }

    public List<AgendamentoDTO> listarTodosAgrupadosPorDataEValor() {
        return agendamentoRepository.findAllGroupByDataHoraAndServicoValor()
                .stream().map(agendamento -> getConverter().map(agendamento, AgendamentoDTO.class))
                .collect(toList());
    }
}
