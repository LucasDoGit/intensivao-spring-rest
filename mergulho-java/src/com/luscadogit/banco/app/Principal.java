package com.luscadogit.banco.app;

import com.luscadogit.banco.modelo.Conta;
import com.luscadogit.banco.modelo.Pessoa;

public class Principal {
    public static void main(String[] args) {
//        primeira conta no banco
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Lucas Timoteo");
        titular1.setDocumento("2324234232");

        Conta minhaConta = new Conta(titular1, 999, 123);
        minhaConta.depositar(750.00);
        minhaConta.sacar(120.00);

//        segunda conta no banco

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Debora Saiz");
        titular2.setDocumento("1532242232");

        Conta suaConta = new Conta(titular2, 888, 321);
        suaConta.depositar(1453.00);
        suaConta.sacar(100.00, 3.00);

//        visulizacao das informacoes das contas
        System.out.println("---------------------------------------------");
        System.out.println("Titular: "    + titular1.getNome());
        System.out.println("Documento: "  + titular1.getDocumento());
        System.out.println("agencia: "    + minhaConta.getAgencia());
        System.out.println("numero: "     + minhaConta.getNumeroConta());
        System.out.println("Saldo: "      + minhaConta.getSaldo());
        System.out.println("---------------------------------------------");
        System.out.println("Titular: "    + titular2.getNome());
        System.out.println("Documento: "  + titular2.getDocumento());
        System.out.println("agencia: "    + suaConta.getAgencia());
        System.out.println("numero: "     + suaConta.getNumeroConta());
        System.out.println("Saldo: "      + suaConta.getSaldo());
        System.out.println("---------------------------------------------");
    }
}
