package com.luscadogit.banco.modelo.atm;

import com.luscadogit.banco.modelo.Conta;
import com.luscadogit.banco.modelo.pagamento.DocumentalEstornavel;
import com.luscadogit.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta) {
        System.out.println("Conta: " + conta.getAgencia() + " / " + conta.getNumeroConta());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponivel: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta) {
        if(documento.estaPago()){
            throw new IllegalStateException("Este documento já está pago");
        }
        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void estornarPagamento(DocumentalEstornavel documento, Conta conta) {
        if(!documento.estaPago()){
            throw new IllegalStateException("Este documento não está pago!");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }
}
