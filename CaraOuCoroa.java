
import java.util.Random;

public class CaraOuCoroa {
    public enum Moeda {
        CARA, COROA;
    }

    public enum Jogo {
        GANHOU, PERDEU;
    }

    private static Moeda lancamento() {
        int aleatorio = new Random().nextInt(2);
        if (aleatorio == 0) {
            return Moeda.CARA;
        }
        return Moeda.COROA;
    }
    public static boolean resultado(Moeda caiu) {
        System.out.println("Lançando...");
        Moeda resultado = lancamento();
        System.out.printf("Resultado: %s%n", resultado);
        return (resultado == caiu);
    }
    public static void main(String[] args) {
        Moeda escolha = Moeda.COROA;
        System.out.printf("Você escolheu %s%n", escolha);
        Jogo jogo = resultado(escolha) ? Jogo.GANHOU : Jogo.PERDEU;
        System.out.printf("Você %s!%n", jogo);
    }
}