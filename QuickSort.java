
import java.util.ArrayList;

public class QuickSort {
    /*********************************************************************************
    * Método quickSortAlgoritmo
    *********************************************************************************/ 
    public static void quickSortAlgoritmo(ArrayList<Integer> vetor, int inicio, int fim) {
        int posicaoPivo;
        if(fim > inicio) {
            posicaoPivo = particiona(vetor, inicio, fim);
            quickSortAlgoritmo(vetor, inicio, posicaoPivo-1);
            quickSortAlgoritmo(vetor, posicaoPivo+1, fim);
        }
    }
    
    /*********************************************************************************
    * Método particiona
    * Descrição: É um método que realiza uma das etapas necessárias para o QuickSort 
    que é posicionar todos o elementos menores que o pivo a esquerda do mesmo e os 
    maiores a direita
    *********************************************************************************/ 
    public static int particiona(ArrayList<Integer> vetor, int inicio, int fim) {
        int esq, dir, pivo, aux;
        esq = inicio;
        dir = fim;
        pivo = vetor.get(inicio);//O pivo começa sendo o elemento da posiçõa inicial do atributo vetor
        
        //Posiciona todos os elementos menores que o pivo a esquerda do mesmo e os maiores a direita
        while (esq < dir) {
            while(vetor.get(esq) <= pivo && esq < fim){//Avança para a direita e só para ao encontrar um elemento maior que o pivo
                esq++;
            }
            while(vetor.get(dir) > pivo && dir > inicio) {//Avança para a esquerda e só para ao encontrar um elemento menor que o pivo
                dir--;
            }
            if(esq < dir) {
                aux = vetor.get(esq);
                vetor.set(esq, vetor.get(dir));
                vetor.set(dir, aux);
            }    
        }
        
        //As duas linhas abaixo posicionam o pivo na posição correta, tirando ele do início do vetor
        vetor.set(inicio, vetor.get(dir));
        vetor.set(dir, pivo);
        
        return dir;//dir é a posição que o pivo está
    }
}
