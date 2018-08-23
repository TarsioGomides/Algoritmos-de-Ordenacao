import java.util.ArrayList;

public class SelectionSort {
    /*********************************************************************************
     * Algoritmo de ordenação por seleção
    *********************************************************************************/
    public static void selectionSortAlgoritmo(ArrayList<Integer> vetor) {
        // armazenam o menor valor e o índice do menor valor
        int menor, indiceMenor;
        
        for (int i = 0; i < vetor.size() - 1; i++) {
            // antes de comparar, considera-se menor o valor atual do loop
            menor = vetor.get(i);
            indiceMenor = i;

            // compara com os outros valores do vetor
            for (int j = i + 1; j < vetor.size(); j++){
                if (vetor.get(j) < menor){
                    menor = vetor.get(j);
                    indiceMenor = j;
                }
            }

            // troca os valores menor e maior		
            vetor.set(indiceMenor, vetor.get(i));
            vetor.set(i, menor);
        }
    }
    
}
