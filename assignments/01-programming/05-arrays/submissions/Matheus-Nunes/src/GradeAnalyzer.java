import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int soma = 0;
        for (int nota : grades) {
            soma += nota;
        }
        return (double) soma / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int maior = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > maior) {
                maior = grades[i];
            }
        }
        return maior;
    }

    public static int findLowestGrade(int[] grades) {
        int menor = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < menor) {
                menor = grades[i];
            }
        }
        return menor;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double media = calculateAverage(grades);
        int quantidade = 0;
        for (int nota : grades) {
            if (nota >= media) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequencia = new int[11];
        for (int nota : grades) {
            if (nota == 100) {
                frequencia[10]++;
            } else {
                frequencia[nota / 10]++;
            }
        }
        return frequencia;
    }

    public static String formatFrequencyLine(int indice, int frequencia) {
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

        double media = calculateAverage(notas);
        int maiorNota = findHighestGrade(notas);
        int menorNota = findLowestGrade(notas);
        int acimaDaMedia = countGradesAtOrAboveAverage(notas);
        int[] frequencia = calculateFrequency(notas);

        System.out.printf("%nMédia da turma: %.2f%n", media);
        System.out.printf("Maior nota: %d%n", maiorNota);
        System.out.printf("Menor nota: %d%n", menorNota);
        System.out.printf("Notas acima ou iguais à média: %d%n", acimaDaMedia);

        System.out.println("\nDistribuição de notas:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }

        leitor.close();
    }
}