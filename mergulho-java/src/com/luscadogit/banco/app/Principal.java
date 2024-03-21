package com.luscadogit.banco.app;

import com.luscadogit.banco.modelo.*;
import com.luscadogit.banco.modelo.atm.CaixaEletronico;
import com.luscadogit.banco.modelo.pagamento.Boleto;
import com.luscadogit.banco.modelo.excecao.SaldoInsuficienteException;
import com.luscadogit.banco.modelo.pagamento.Holerite;

public class Principal {
    public static void main(String[] args) {
//        primeira conta no banco
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Lucas Timoteo");
        titular1.setDocumento("2324234232");

//        segunda conta no banco
        Pessoa titular2 = new Pessoa();
        titular2.setNome("Debora Saiz");
        titular2.setDocumento("1532242232");

//        instancia o caixa eletronico
        CaixaEletronico caixaEletronico = new CaixaEletronico();

//        instancia os tipos de contas de cada titular
        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 999, 123);
        ContaEspecial suaConta = new ContaEspecial(titular2, 888, 321, 1000);

/*
        Conta conta = minhaConta; // Polimorfismo
        Conta conta = (Conta) minhaConta); // instrucao explicita
        conta.debitarTarifaMensal();
*/

        try {
            minhaConta.depositar(30_000);
            minhaConta.sacar(1_000);

            suaConta.depositar(15_000);
            suaConta.sacar(15_500);
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, 35_000);
            Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
