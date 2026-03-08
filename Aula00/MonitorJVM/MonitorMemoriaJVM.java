package MonitorJVM;
public class MonitorMemoriaJVM {

    public static void main(String[] args) {

        // A classe Runtime representa o ambiente de execução da JVM.
        // Ela permite acessar informações sobre memória, processadores
        // e também executar ações como chamar o Garbage Collector.
        Runtime rt = Runtime.getRuntime();

        // totalMemory() retorna a quantidade total de memória que a JVM
        // reservou atualmente para execução do programa.
        System.out.println("Memoria total alocada para a JVM: " + rt.totalMemory() + " bytes");

        // gc() solicita que a JVM execute o Garbage Collector,
        // que é responsável por liberar objetos que não estão mais sendo usados.
        rt.gc();

        System.out.println("Memoria total apos executar o GC: " + rt.totalMemory() + " bytes");

        // Variáveis que irão armazenar a memória livre antes e depois da criação do vetor
        double m1, m2;

        // freeMemory() retorna a quantidade de memória disponível
        // dentro da memória já alocada para a JVM.
        m1 = rt.freeMemory();

        System.out.println("Memoria disponivel antes de criar o vetor: " + m1 + " bytes");

        // Criação de um vetor com 100.000 posições.
        // Vetores são objetos em Java e são armazenados na HEAP,
        // pois são alocados dinamicamente durante a execução do programa.
        double vetor[] = new double[100000];

        // Preenchendo o vetor para evitar que a JVM otimize ou ignore a alocação.
        // Algumas JVMs podem otimizar objetos que não são utilizados.
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }

        // Verifica novamente a memória livre depois da criação do vetor
        m2 = rt.freeMemory();

        System.out.println("Memoria disponivel depois de criar o vetor: " + m2 + " bytes");

        // Calcula aproximadamente a quantidade de memória utilizada
        System.out.println("Memoria utilizada pelo vetor: " + (m1 - m2) + " bytes");

        // Solicita novamente a execução do Garbage Collector
        rt.gc();

        // Mostra a memória disponível após tentativa de limpeza
        System.out.println("Memoria disponivel apos executar o Garbage Collector: " + rt.freeMemory() + " bytes");

    }
}