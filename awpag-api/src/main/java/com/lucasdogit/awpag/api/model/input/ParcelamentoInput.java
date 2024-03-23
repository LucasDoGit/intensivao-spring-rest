package com.lucasdogit.awpag.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ParcelamentoInput {

    @NotBlank
    @Size (max = 20)
    private String descricao;

    @Positive
    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    @Max(12)
    @Positive
    private Integer quantidadeParcelas;

    @Valid
    @NotNull
    private ClienteIdInput cliente;
}
