package br.com.fiap.primeira_api.service;

import br.com.fiap.primeira_api.dto.ClienteRequest;
import br.com.fiap.primeira_api.dto.ClienteResponse;
import br.com.fiap.primeira_api.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
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
}
