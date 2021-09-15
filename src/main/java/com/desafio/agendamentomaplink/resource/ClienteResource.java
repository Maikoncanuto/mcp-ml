package com.desafio.agendamentomaplink.resource;

import com.desafio.agendamentomaplink.domain.dto.ClienteDTO;
import com.desafio.agendamentomaplink.domain.dto.ResponseDTO;
import com.desafio.agendamentomaplink.repository.ClienteRepository;
import com.desafio.agendamentomaplink.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteResource {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        return ok(new ResponseDTO(clienteService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody final ClienteDTO clienteDTO) {
        final ClienteDTO retorno = clienteService.save(clienteDTO);

        return status(CREATED).body(new ResponseDTO(retorno));
    }

    @PutMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ResponseDTO> update(@PathVariable("id") final long id, @RequestBody final ClienteDTO clienteDTO) {
        final ClienteDTO retorno = clienteService.update(id, clienteDTO);

        if (!isNull(retorno))
            return ok().body(new ResponseDTO(retorno));
        else
            return notFound().build();
    }

    @DeleteMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<?> delete(@PathVariable final long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.deleteById(id);
                    return noContent().build();
                }).orElse(notFound().build());
    }

}
