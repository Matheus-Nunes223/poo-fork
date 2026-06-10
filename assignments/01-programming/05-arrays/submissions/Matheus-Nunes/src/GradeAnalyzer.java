import java.util.Scanner;

public class GradeAnalyzer {

    public static double calcularMedia(int[] notas) {
        int soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        return (double) soma / notas.length;
    }

    public static int encontrarMaiorNota(int[] notas) {
        int maior = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maior) {
                maior = notas[i];
            }
        }
        return maior;
    }

    public static int encontrarMenorNota(int[] notas) {
        int menor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    public static int contarNotasAcimaOuIguaisAMedia(int[] notas) {
        double media = calcularMedia(notas);
        int quantidade = 0;
        for (int nota : notas) {
            if (nota >= media) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static int[] calcularFrequencia(int[] notas) {
        int[] frequencia = new int[11];
        for (int nota : notas) {
            if (nota == 100) {
                frequencia[10]++;
            } else {
                frequencia[nota / 10]++;
            }
        }
        return frequencia;
    }

    public static String formatarLinhaFrequencia(int indice, int frequencia) {
        if (indice == 10) {
            return String.format("100: %d", frequencia);
        } else {
            int minimo = indice * 10;
            int maximo = minimo + 9;
            return String.format("%02d-%02d: %d", minimo, maximo, frequencia);
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int quantidadeEstudantes = 0;
        while (quantidadeEstudantes <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            quantidadeEstudantes = leitor.nextInt();
            if (quantidadeEstudantes <= 0) {
                System.out.println("Quantidade inválida. Informe um valor maior que zero.");
            }
        }

        int[] notas = new int[quantidadeEstudantes];
        for (int i = 0; i < quantidadeEstudantes; i++) {
            int nota = -1;
            while (nota < 0 || nota > 100) {
                System.out.printf("Digite a nota do estudante %d: ", i + 1);
                nota = leitor.nextInt();
                if (nota < 0 || nota > 100) {
                    System.out.println("Nota inválida. Informe um valor entre 0 e 100.");
                }
            }
            notas[i] = nota;
        }

        double media = calcularMedia(notas);
        int maiorNota = encontrarMaiorNota(notas);
        int menorNota = encontrarMenorNota(notas);
        int acimaDaMedia = contarNotasAcimaOuIguaisAMedia(notas);
        int[] frequencia = calcularFrequencia(notas);

        System.out.printf("%nMédia da turma: %.2f%n", media);
        System.out.printf("Maior nota: %d%n", maiorNota);
        System.out.printf("Menor nota: %d%n", menorNota);
        System.out.printf("Notas acima ou iguais à média: %d%n", acimaDaMedia);

        System.out.println("\nDistribuição de notas:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(formatarLinhaFrequencia(i, frequencia[i]));
        }

        leitor.close();
    }
}