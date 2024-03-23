package com.lucasdogit.awpag.api.controller;

import com.lucasdogit.awpag.api.assembler.ParcelamentoAssembler;
import com.lucasdogit.awpag.api.model.ParcelamentoModel;
import com.lucasdogit.awpag.api.model.input.ParcelamentoInput;
import com.lucasdogit.awpag.domain.exception.NegocioException;
import com.lucasdogit.awpag.domain.model.Parcelamento;
import com.lucasdogit.awpag.domain.repository.ParcelamentoRepository;
import com.lucasdogit.awpag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
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
    private final ParcelamentoAssembler parcelamentoAssembler;

    @GetMapping
    public List<ParcelamentoModel> listar() {
        return parcelamentoAssembler.toCollectionModel(parcelamentoRepository.findAll());
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .map(parcelamentoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcelamentoModel cadastrar(@Valid @RequestBody ParcelamentoInput parcelamentoInput) {
        Parcelamento novoParcelamento = parcelamentoAssembler.toEntity(parcelamentoInput);
        Parcelamento parcelamentoCadastrado = parcelamentoService.cadastrar(novoParcelamento);
        return parcelamentoAssembler.toModel(parcelamentoCadastrado);
    }
}
