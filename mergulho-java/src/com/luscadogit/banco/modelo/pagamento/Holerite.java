package com.luscadogit.banco.modelo.pagamento;

import com.luscadogit.banco.modelo.Pessoa;

public class Holerite implements DocumentoPagavel {

    private Pessoa funcionario;
    private double valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, double hora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = hora;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public double getValorTotal() {
        return valorHora * quantidadeHoras;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
