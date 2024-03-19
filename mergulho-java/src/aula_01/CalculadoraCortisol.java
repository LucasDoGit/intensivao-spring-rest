package aula_01;

public class CalculadoraCortisol {
    
    public static void main(String args[]) {
        double cortisol = 18.2;
        
        // boolean resultadoNormal = cortisol >= 6.0 && cortisol <= 18.4;
        // boolean resultadoAnormal = cortisol < 6.0 || cortisol > 18.4;
        
        // boolean resultadoAnormal = !resultadoNormal;
        
        // System.out.println("Resultado cortisol: " + resultadoNormal);
        // System.out.println("Resultado anormal: " + resultadoAnormal);
        
        if(cortisol >= 6.0 && cortisol <= 18.4) {
            System.out.println("cortisol normal");
        } else if (cortisol > 18.4) {
            System.out.println("cortisol alto");
        } else {
            System.out.println("cortisol baixo");
        }
    }
    
}