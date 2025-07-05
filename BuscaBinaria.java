import java.util.Scanner;

public class BuscaBinaria {
    public static int binario(int[] arr, int objetivo) {
        int esquerda = 0;
        int direita = arr.length -1;
        int tentativas = 0;

        System.out.println("\n Procurando o número " + objetivo + " na lista...");
        System.out.println("Lista tem " + arr.length + "elementos (de" + arr[0] + " até " + arr[arr.length-1] + ")");
        System.out.println("-------------------------------------------------------");

        while (esquerda <= direita) {
            tentativas++;
            int meio = esquerda + (direita - esquerda) / 2;

            System.out.println("Tentativa " + tentativas + ":");
            System.out.println(" Posição: " + meio + "| Valor: " + arr[meio]);
            System.out.println(" Intervalo: [" + esquerda + ", " + direita + "]");

            // Se encontrar o elemento procurado
            if (arr[meio] == objetivo) {
                System.out.println("Número " + objetivo + " está na posição " + meio);
                System.out.println("Encontrado em " + tentativas + " tentativas");
                return meio;
            }

            if (arr[meio] < objetivo) {
                System.out.println(" " + arr[meio] + " < " + objetivo + "-> Buscar na metade da direita");
                esquerda = meio + 1;
            }

            else {
                System.out.println(" " + arr[meio] + " > " + objetivo + "-> Buscar na metade da esquerda");
                direita = meio - 1;
            }
            System.out.println();
        }

        System.out.println(" Número " + objetivo + " não encontrado na lista");
        System.out.println(" Foram feitas " + tentativas + " tentativas");
        return -1;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] numeros = new int[100];
    for (int i = 0; i < 100; i++) {
        numeros[i] = i + 1;
    }

    System.out.println("============================================");
    System.out.println(" Busca Binária Interativa");
    System.out.println("============================================");
    System.out.println("Lista com números de 1 a 100 ordenados");

    while (true) {
        try {
            System.out.println("\n" + "=================================================");
            System.out.print("Digite o número que deseja procurar (0 pra sair):");
            int numero = scanner.nextInt();

            if (numero == 0) {
                System.out.println("Programa encerrado!");
                break;
            }
            if (numero < 1 || numero > 100){
                System.out.println("Por favor, digite um número entre 1 e 100");
                continue;
            }

            int resultado = binario(numeros, numero);

            if (resultado != -1) {
                System.out.println("Comparação: Em uma busca linear, seria necessário");
                System.out.println(" até " + numero + " comparações. A busca binária usou apenas");
                System.out.println("  algumas tentativas!");

            }

            System.out.print("\nDeseja fazer outra busca? (s/n)");
            String continuar = scanner.next();
            if (!continuar.toLowerCase().equals("s") && !continuar.toLowerCase().equals("sim")) {
                System.out.println("Programa encerrado!");
                break;
            }
        } catch (Exception e ) {
            System.out.println("Por favor, digite um número válido!");
            scanner.nextLine(); // Limpa buffer
        }

        scanner.close();
    }
}
}