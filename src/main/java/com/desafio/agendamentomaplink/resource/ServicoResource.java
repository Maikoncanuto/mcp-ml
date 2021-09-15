package com.desafio.agendamentomaplink.resource;

import com.desafio.agendamentomaplink.domain.dto.ResponseDTO;
import com.desafio.agendamentomaplink.domain.dto.ServicoDTO;
import com.desafio.agendamentomaplink.repository.ServicoRepository;
import com.desafio.agendamentomaplink.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoResource {

    private final ServicoService servicoService;
    private final ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        return ok(new ResponseDTO(servicoService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody final ServicoDTO clienteDTO) {
        final ServicoDTO retorno = servicoService.save(clienteDTO);

        return status(CREATED).body(new ResponseDTO(retorno));
    }

    @PutMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ResponseDTO> update(@PathVariable("id") final long id, @RequestBody final ServicoDTO clienteDTO) {

        final ServicoDTO retorno = servicoService.update(id, clienteDTO);

        if (!isNull(retorno))
            return ok().body(new ResponseDTO(retorno));
        else
            return notFound().build();
    }

    @DeleteMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<?> delete(@PathVariable final long id) {
        return servicoRepository.findById(id)
                .map(cliente -> {
                    servicoRepository.deleteById(id);
                    return noContent().build();
                }).orElse(notFound().build());
    }
}
