package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.model.Cliente;
import br.com.fiap.primeira_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //CRUD
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteCriado = clienteRepository.save(cliente);
        return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> readAll() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
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
        cliente.setId(id);
        Cliente clienteCriado = clienteRepository.save(cliente);
        return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Cliente clienteDelete = clienteRepository.getReferenceById(id);
        clienteRepository.delete(clienteDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
