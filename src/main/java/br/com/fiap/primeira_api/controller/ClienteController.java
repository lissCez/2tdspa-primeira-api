package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.dto.ClienteRequest;
import br.com.fiap.primeira_api.dto.ClienteResponse;
import br.com.fiap.primeira_api.model.Cliente;
import br.com.fiap.primeira_api.repository.ClienteRepository;
import br.com.fiap.primeira_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    //CRUD
    @PostMapping
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteService.requestToCliente(clienteRequest);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteResponse clienteResponse = clienteService.clienteToResponse(clienteSalvo);
        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponse>> read() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> read(@PathVariable int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        Cliente clienteUpdate;
        if (clienteSalvo.isPresent()) {
            cliente.setId(id);
            clienteUpdate = clienteRepository.save(cliente);
            return new ResponseEntity<>(clienteUpdate, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        if (clienteSalvo.isPresent()) {
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
