package com.lucasdogit.awpag.domain.model;

import com.lucasdogit.awpag.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity // relaciona a classe cliente com a tabela cliente no banco de dados
//@Table(name = "tb_cliente") // caso o nome seja diferente
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // usa loombok para criar hashcode usando somente variaveis explicitas
// gera os Getters e Setters de forma nao explicita
@Getter
@Setter

public class Cliente {

    @NotNull(groups = ValidationGroups.ClienteId.class)
    @EqualsAndHashCode.Include // gera o hash code usando apenas o ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // nao aceita nomes em nulos ou em branco
    @Size(max = 60)
//    @Column(name = "nome) // caso o nome seja igual nao e preciso especificar cada variavel para o BD.
    private String nome;

    @NotBlank
    @Size(max = 255)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "fone")
    private String telefone;

}
