package aula_01;

public class CalculadoraJurosCompostosFor {
    
    public static void main(String args[]) {
        double valorAcumulado = 10.000;
        double taxaJurosMensal = 0.8;
        int periodoemMeses = 12;
        
        for (int mes = 1; mes <= periodoemMeses; mes++) {
            valorAcumulado += valorAcumulado * taxaJurosMensal / 100;
            System.out.println("Mês " + mes + " = " + valorAcumulado);
        }
    }
}