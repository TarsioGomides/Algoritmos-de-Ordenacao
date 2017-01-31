import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static int algoritmo_a_executar;//1 - selection
    /*********************************************************************************
     * Serve para ler os valores de um arquivo e passálos para um array
     * -Colocar para retornar um ArrayList
     * -Mudar de array para ArrayList
    *********************************************************************************/
    private static ArrayList<Integer> readFile(String fileName) {
        ArrayList<Integer> valores_extraidos_arquivo = new ArrayList<Integer> ();
    	try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            algoritmo_a_executar = Integer.parseInt(scanner.next());
            
            while (scanner.hasNext()) {
           	valores_extraidos_arquivo.add(Integer.parseInt(scanner.next()));    
            }
            
            scanner.close();
       	} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return valores_extraidos_arquivo;
    }

    /*********************************************************************************
     * Algoritmo de ordenação por seleção
    *********************************************************************************/
    public static void selectionSort(ArrayList<Integer> vetor) {
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
    
    /*********************************************************************************
     * Método insertionSort
    *********************************************************************************/
	public static void insertionSort(ArrayList<Integer> vetor) {
        for(int i = 1;  i < vetor.size(); i++){
            int hold = vetor.get(i);
            int j = i;
            
            while(j>0 && vetor.get(j-1)>hold){
                vetor.set(j, vetor.get(j-1));
                j--;
            }
            
            vetor.set(j, hold);
        }
    }
    
    /*********************************************************************************
     * Nome: mergeSort(int vetor[], int inicio, int fim)
     * Descrição geral do algoritmo: 1 - Divida o vetor ao meio
     * 1.1 - Recursivamente ordene a primeira metade do vetor
     * 1.2 - Recursivamente ordene a segunda metade do vetor
     * 1.3 - Intercale os dois sub-vetores gerando um vetor ordenado
     * 
    *********************************************************************************/    
    public static void mergeSort(ArrayList<Integer> vetor, ArrayList<Integer> auxiliar, int inicio, int fim) {
        if(inicio < fim) {
            int meio = (inicio + fim) / 2;//calcula  qual é o índice do elemento que está no meio do vetor
            mergeSort(vetor, auxiliar, inicio, meio);//chamando o método mergeSort recursivamente para uma metade do vetor
            mergeSort(vetor, auxiliar, meio + 1, fim);//chamando o método mergeSort recursivamente para outra metade do vetor
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
    }
    
    /*********************************************************************************
     * Método intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim)
     * Descrição: É um método auxiliar ao método mergeSort, ajudando a intercalar
    *********************************************************************************/        
    private static void intercalar(ArrayList<Integer> vetor, ArrayList<Integer> auxiliar, int inicio, 
                                                                                    int meio, int fim) {
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

	/*********************************************************************************
     * Nome: quickSort(ArrayList<Integer> vetor, int esquerda, int direita)
     * Descrição geral do algoritmo: 1 - Escolha um elemento pivô
     * 2 - Separe elementos menores que o pivô para a esquerda e elementos maiores
     * do que o pivô para a direita
     * 3 - Recursivamente, execute o mesmo procedimento para elementos a esquerda 
     * do pivô
     * 4 - Recursivamente, execute o mesmo procedimento para elementos a direita 
     * do pivô
    *********************************************************************************/
    private static void quickSort(ArrayList<Integer> vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int j = separar(vetor, esquerda, direita);//separa o vetor e o j guarda o valor do pivô
            quickSort(vetor, esquerda, j-1);
            quickSort(vetor, j+1, direita);
        }
    }
    
    /*********************************************************************************
     * Método separar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim)
     * Descrição: É um método auxiliar ao método quickSort, ajudando a dividir o vetor
    *********************************************************************************/
    private static int separar(ArrayList<Integer> vetor, int esquerda, int direita) {
        int i = esquerda, j = direita;
        
        while(i < j) {
            while(i<direita && vetor.get(i)<=vetor.get(esquerda))
                i++;
            while(j>esquerda && vetor.get(j)>=vetor.get(esquerda))
                j--;
            if(i < j) {
                trocar(vetor, i, j);//colocar os elementos maiores a direita do pivô e os menores a esquerda
                i++;
                j--;   
            }    
        }
        //coloca o pivô na posição correta
        trocar(vetor, esquerda, j);
         
        return j;//retorna a posição do pivô
    }
    
    /*********************************************************************************
     * Método trocar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim)
     * Descrição: É um método auxiliar ao método quickSort, ajudando a trocar
     * elementos de posição
    *********************************************************************************/
    private static void trocar(ArrayList<Integer> vetor, int i, int j){
        int aux = vetor.get(i);
        vetor.set(i, vetor.get(j));
        vetor.set(j, aux);
    }

	/*********************************************************************************
     * Nome: heapSort
     * Descrição geral do algoritmo: 
    *********************************************************************************/
    public static void heapSort(ArrayList<Integer> vetor) {
        buildMaxHeap(vetor);
        int n = vetor.size();

        for (int i = vetor.size() - 1; i > 0; i--) {
            swap(vetor, i, 0);
            maxHeapify(vetor, 0, --n);
        }
    }

    private static void buildMaxHeap(ArrayList<Integer> vetor) {
        for (int i = vetor.size() / 2 - 1; i >= 0; i--)
            maxHeapify(vetor, i, vetor.size());
    }

    private static void maxHeapify(ArrayList<Integer> vetor, int pos, int tamanhoDoVetor) {  
        int max = 2 * pos + 1, direita = max + 1;  
        if (max < tamanhoDoVetor) {  
             if (direita < tamanhoDoVetor && vetor.get(max) < vetor.get(direita))  
                 max = direita;

             if (vetor.get(max) > vetor.get(pos)) {  
                 swap(vetor, max, pos);  
                 maxHeapify(vetor, max, tamanhoDoVetor);  
             }  
        }  
    }

    public static void swap(ArrayList<Integer> vetor, int j, int aposJ) {
        int aux = vetor.get(j);
        vetor.set(j, vetor.get(aposJ));
        vetor.set(aposJ, aux);
    }

    /*********************************************************************************
     * Método main
    *********************************************************************************/        
    public static void main(String[] args) {
        ArrayList<Integer> valores_extraidos_arquivo = readFile(args[0]);
        ArrayList<Integer> valores_para_selection = valores_extraidos_arquivo;
        ArrayList<Integer> valores_para_insertion = valores_extraidos_arquivo;
        ArrayList<Integer> valores_para_merge = valores_extraidos_arquivo;
        ArrayList<Integer> valores_para_quick = valores_extraidos_arquivo;
		ArrayList<Integer> valores_para_heap = valores_extraidos_arquivo;
        
        switch (algoritmo_a_executar) {
            case 1:
                System.out.println("---------------------------- \n Executando selectionSort \n----------------------------");
                selectionSort(valores_para_selection);
		
                for(int n : valores_para_selection){
                    System.out.println(n);
                }
                break;
            case 2:
                System.out.println("---------------------------- \n Executando insertionSort \n----------------------------");
				insertionSort(valores_para_insertion);

				for(int n : valores_para_insertion){
                    System.out.println(n);
                }
                break;
            case 3:
                System.out.println("---------------------------- \n Executando mergeSort \n----------------------------");
				ArrayList<Integer> auxiliar = new ArrayList<Integer> ();
				mergeSort(valores_para_merge, auxiliar, 0, valores_para_merge.size()-1);

				for(int n : valores_para_merge){
                    System.out.println(n);
                }
                break;
            case 4:
                System.out.println("---------------------------- \n Executando quickSort \n----------------------------");
				quickSort(valores_para_quick, 0, valores_para_quick.size()-1);

				for(int n : valores_para_quick){
                    System.out.println(n);
                }
                break;
            case 5:
                System.out.println("---------------------------- \n Executando heapSort \n----------------------------");
				heapSort(valores_para_heap);

				for(int n : valores_para_heap){
                    System.out.println(n);
                }
                break;         
        }
    }
    
}

