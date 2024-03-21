package com.luscadogit.banco.modelo;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Pessoa titular, int agencia, int numeroConta){
        super(titular, agencia, numeroConta); // chama o construtor da superclasse "Conta"
    }

    @Override
    public void debitarTarifaMensal() {
        if(getSaldo() < 10.000){
            sacar(30);
        }
    }

    public void creditarRedimentos(double percentualJuros){
        double valorRedimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRedimentos);
    }
}
