import java.util.ArrayList;
   
public class MergeSort {
    /*********************************************************************************
     * Nome: mergeSort(int vetor[], int inicio, int fim)
     * Descrição geral do algoritmo: 
     * 1 - Divida o vetor ao meio
     * 1.1 - Recursivamente ordene a primeira metade do vetor
     * 1.2 - Recursivamente ordene a segunda metade do vetor
     * 1.3 - Intercale os dois sub-vetores gerando um vetor ordenado
     * 
    *********************************************************************************/ 
    public static void mergeSortAlgoritmo(ArrayList<Integer> vetor, ArrayList<Integer> auxiliar, int inicio, int fim) {
        if(inicio < fim) {
            int meio = (inicio + fim) / 2;//calcula qual é o índice do elemento que está no meio do vetor
            mergeSortAlgoritmo(vetor, auxiliar, inicio, meio);//chamando o método mergeSort recursivamente para uma metade do vetor
            mergeSortAlgoritmo(vetor, auxiliar, meio + 1, fim);//chamando o método mergeSort recursivamente para outra metade do vetor
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
    }
    
    /*********************************************************************************
     * Método intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim)
     * Descrição: É um método auxiliar ao método mergeSort, ajudando a intercalar
    *********************************************************************************/        
    private static void intercalar(ArrayList<Integer> vetor, ArrayList<Integer> auxiliar, int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++)
            auxiliar.add(k, vetor.get(k));//faz uma cópia de vetor dentro de auxiliar
        
        int i = inicio;//variável para andar na primeira metade do vetor
        int j = meio +1;//variável para andar na segunda metade do vetor
        
        //faz a intercalação entre os 2 subvetores
        for(int k = inicio; k <= fim; k++){
            //se a primeira metade do vetor ultrapassou o meio, ou seja, se a primeira metade acabou
            if(i > meio)
                vetor.set(k, auxiliar.get(j++));
            //se a segunda metade do vetor ultrapassou o final, ou seja, se a segunda metade acabou
            else if(j > fim)
                vetor.set(k, auxiliar.get(i++));
            //se ainda existem elementos na primeira metade e na segunda metade
            else if(auxiliar.get(i) < auxiliar.get(j)) 
                vetor.set(k, auxiliar.get(i++));
            else
                vetor.set(k, auxiliar.get(j++));
        }
            
    }
}
