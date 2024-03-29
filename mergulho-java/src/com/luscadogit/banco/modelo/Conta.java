package com.luscadogit.banco.modelo;

import com.luscadogit.banco.modelo.excecao.SaldoInsuficienteException;

import java.util.Objects;

public abstract class Conta {

//    encapsulamento das variaveis de instancia
    private Pessoa titular;
    private int agencia;
    private int numeroConta;
    private double saldo;

//    construtor
    public Conta(Pessoa titular, int agencia, int numeroConta){
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

//    sobrecarga do construtor
    public Conta() {

    }

    public void depositar(double valor) {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        if (getSaldoDisponivel() - valor <0){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo -= valor;
    }

//    sobrecarga do metodo sacar
    public void sacar(double valor, double taxaSaque) {
        sacar(valor + taxaSaque);
    }

    public abstract void debitarTarifaMensal();

//    metodos get e set
    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }
}
