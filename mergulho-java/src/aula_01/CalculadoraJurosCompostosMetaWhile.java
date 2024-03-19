package aula_01;

public class CalculadoraJurosCompostosMetaWhile {
    
    public static void main(String args[]) {
        double valorAcumulado = 10.000;
        double valorMeta = 20.000;
        double taxaJurosMensal = 0.8;
        int mes = 0;
        
        while (valorAcumulado < valorMeta) {
            mes++;
            
            valorAcumulado += valorAcumulado * taxaJurosMensal / 100;
            System.out.println("Mês " + mes + " = " + valorAcumulado);
        }
    }
}