package com.lucasdogit.awpag.domain.service;

import com.lucasdogit.awpag.domain.exception.NegocioException;
import com.lucasdogit.awpag.domain.model.Cliente;
import com.lucasdogit.awpag.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {

        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(c -> !c.equals(cliente)) // filtra se o cliente retornado e diferente do cliente que esta sendo cadastrado/atualizado
                .isPresent();

        if(emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastro com este e-mail.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
