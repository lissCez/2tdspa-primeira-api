package br.com.fiap.primeira_api.service;

import br.com.fiap.primeira_api.dto.ClienteRequest;
import br.com.fiap.primeira_api.dto.ClienteResponse;
import br.com.fiap.primeira_api.model.Cliente;
import br.com.fiap.primeira_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;



    public Cliente requestToCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setSenha(clienteRequest.getSenha());
        return cliente;
    }

    public ClienteResponse clienteToResponse(Cliente cliente) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setEmail(cliente.getEmail());
        return clienteResponse;
    }
    // Paginação
    private static final Pageable customPageable = PageRequest.of(0, 3, Sort.by("email").ascending());

    public Page<ClienteResponse> findAll() {
        return clienteRepository.findAll(customPageable).map(this::clienteToResponse);
    }
}
