package com.lucasdogit.awpag.api.controller;

import com.lucasdogit.awpag.domain.exception.NegocioException;
import com.lucasdogit.awpag.domain.model.Parcelamento;
import com.lucasdogit.awpag.domain.repository.ParcelamentoRepository;
import com.lucasdogit.awpag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;

    @GetMapping
    public List<Parcelamento> listar() {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<Parcelamento> buscar(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento) {
        return parcelamentoService.cadastrar(parcelamento);
    }
}
