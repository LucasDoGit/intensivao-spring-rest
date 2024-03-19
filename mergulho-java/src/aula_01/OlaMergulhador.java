package aula_01;

public class OlaMergulhador {
    public static void main(String[] args) {
        System.out.println("Olá, Mergulhador");

        String nomeCompleto = "Lucas Timoteo";
        // nomeCompleto = "Lucas Timoteo";

        System.out.println("Nome: " + nomeCompleto);

        int minhaIdade = 21;
        int suaIdade = 25;
        int totalIdades = minhaIdade + suaIdade;

        System.out.println("Soma das idades: " + totalIdades);

        double peso = 84.9d;
        System.out.println("peso: " + peso);

        float taxa = 1284.9f;
        System.out.println("taxa: " + taxa);

        boolean compraAprovada = false;
        System.out.println(compraAprovada);

        boolean maiorDeIdade = minhaIdade > 18;
        System.out.println(maiorDeIdade);
    }

}
