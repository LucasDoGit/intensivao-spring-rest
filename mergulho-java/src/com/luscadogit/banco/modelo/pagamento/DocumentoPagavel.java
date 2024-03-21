package com.luscadogit.banco.modelo.pagamento;

public interface DocumentoPagavel {

    public double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("Recibo: ");
        System.out.println("Valor total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }
}
