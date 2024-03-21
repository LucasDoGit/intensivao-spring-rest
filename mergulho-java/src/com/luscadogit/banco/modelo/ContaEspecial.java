package com.luscadogit.banco.modelo;

public class ContaEspecial extends Conta {

    private double valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numeroConta, double valorLimite) {
        super(titular, agencia, numeroConta);
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(20);
    }

    //    sobrescrita do metodo getSaldo para contas especiais.
    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + getValorLimite();
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

}
