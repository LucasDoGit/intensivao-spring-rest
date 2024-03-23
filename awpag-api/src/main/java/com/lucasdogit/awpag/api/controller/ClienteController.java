package com.lucasdogit.awpag.api.controller;

import com.lucasdogit.awpag.domain.exception.NegocioException;
import com.lucasdogit.awpag.domain.model.Cliente;
import com.lucasdogit.awpag.domain.repository.ClienteRepository;
import com.lucasdogit.awpag.domain.service.CadastroClienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/clientes") // mapeia todos os endpoints
@AllArgsConstructor // cria construtores para todas as variaveis de instancia do controlador
@RestController
public class ClienteController {

    private final CadastroClienteService cadastroClienteService;
    private final ClienteRepository clienteRepository;

//    busca todos os clientes
    @GetMapping // mapeia o endpoint
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

//    busca cliente pelo ID
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

//    adiciona clientes
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return cadastroClienteService.salvar(cliente);
    }

//    atualiza um cliente pelo ID
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                                             @Valid @RequestBody Cliente cliente) {

        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = cadastroClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

//    deleta um cliente pelo ID
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        cadastroClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }
}
