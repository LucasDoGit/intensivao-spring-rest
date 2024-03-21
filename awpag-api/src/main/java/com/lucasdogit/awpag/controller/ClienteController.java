package com.lucasdogit.awpag.controller;

import com.lucasdogit.awpag.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Lucas Thiago Saiz Timoteo");
        cliente1.setTelefone("41 99654-6683");
        cliente1.setEmail("lucas.timoteo@awpag.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Debora Saiz");
        cliente2.setTelefone("41 99865-3097");
        cliente2.setEmail("debora.saiz@awpag.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
