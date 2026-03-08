package AtividadeVetoresAS008;

import java.util.Scanner;

public class VetoresIndiceValor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaração do vetor exatamente como mostrado no slide.
        // Um vetor permite armazenar vários valores usando apenas um nome de variável.
        int[] vetor = {9, 5, 7, 2, 6, 22, 9, 4, 10, 14};

        System.out.println("=== VETOR ORIGINAL ===");

        // O índice representa a posição dentro do vetor
        System.out.print("Indice:  ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        // O valor é o conteúdo armazenado naquela posição
        System.out.print("Valores: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println("\n");

        // =========================
        // PARTE A – BUSCAR POR ÍNDICE
        // =========================

        System.out.print("Digite um indice (0 a 9): ");
        int indice = sc.nextInt();

        // Validação para evitar acessar posições inexistentes no vetor
        if (indice >= 0 && indice < vetor.length) {
            System.out.println("O valor na posicao " + indice + " é: " + vetor[indice]);
        } else {
            System.out.println("Indice invalido!");
        }

        System.out.println();

        // =========================
        // PARTE B – ALTERAR VALOR
        // =========================

        System.out.print("Digite um indice para alterar (0 a 9): ");
        int indiceAlterar = sc.nextInt();

        if (indiceAlterar >= 0 && indiceAlterar < vetor.length) {

            System.out.print("Digite o novo valor: ");
            int novoValor = sc.nextInt();

            // Atualizando o valor naquela posição
            vetor[indiceAlterar] = novoValor;

            System.out.println("\nVetor atualizado:");

            for (int i = 0; i < vetor.length; i++) {
                System.out.print(vetor[i] + " ");
            }

        } else {
            System.out.println("Indice invalido!");
        }

        System.out.println("\n");

        // =========================
        // PARTE C – RELATÓRIO
        // =========================

        int maior = vetor[0];
        int indiceMaior = 0;

        int menor = vetor[0];
        int indiceMenor = 0;

        int soma = 0;

        int pares = 0;
        int impares = 0;

        // Percorrendo todo o vetor para analisar os valores
        for (int i = 0; i < vetor.length; i++) {

            soma += vetor[i];

            // Verifica maior valor
            if (vetor[i] > maior) {
                maior = vetor[i];
                indiceMaior = i;
            }

            // Verifica menor valor
            if (vetor[i] < menor) {
                menor = vetor[i];
                indiceMenor = i;
            }

            // Verifica se é par ou ímpar
            if (vetor[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        double media = (double) soma / vetor.length;

        System.out.println("=== RELATORIO DO VETOR ===");

        System.out.println("Maior valor: " + maior + " (indice " + indiceMaior + ")");
        System.out.println("Menor valor: " + menor + " (indice " + indiceMenor + ")");
        System.out.println("Soma dos valores: " + soma);
        System.out.println("Media: " + media);
        System.out.println("Quantidade de pares: " + pares);
        System.out.println("Quantidade de impares: " + impares);

        System.out.println();

        // =========================
        // DESAFIO EXTRA – BUSCA
        // =========================

        System.out.print("Digite um numero para buscar no vetor: ");
        int busca = sc.nextInt();

        int contador = 0;

        System.out.print("Indices encontrados: ");

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] == busca) {
                System.out.print(i + " ");
                contador++;
            }
        }

        System.out.println();

        if (contador > 0) {
            System.out.println("O numero aparece " + contador + " vez(es) no vetor.");
        } else {
            System.out.println("O numero nao foi encontrado no vetor.");
        }

        sc.close();
    }
}