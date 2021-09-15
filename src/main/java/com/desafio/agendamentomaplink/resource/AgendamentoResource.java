package com.desafio.agendamentomaplink.resource;

import com.desafio.agendamentomaplink.domain.dto.ResponseDTO;
import com.desafio.agendamentomaplink.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoResource {

    private final AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        return ok(new ResponseDTO(agendamentoService.findAll()));
    }

    @GetMapping(path = "/grouping")
    public ResponseEntity<ResponseDTO> listarTodosAgrupadosPorDataEValor() {
        return ok(new ResponseDTO(agendamentoService.listarTodosAgrupadosPorDataEValor()));
    }
}
