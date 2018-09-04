import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecucaoDosAlgoritmos {
    /*********************************************************************************
     * Serve para ler os valores de um arquivo e passálos para um array
    *********************************************************************************/
    private static ArrayList<Integer> readFile(String fileName) {
        ArrayList<Integer> valores_extraidos_arquivo = new ArrayList<>();
    	try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            
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
     * Método main
    *********************************************************************************/        
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Argumentos a mais ou a menos foram passados." +
                " A chamada correta seria --> \"java MinhaClasse NumeroDoAlgoritmoAExecutar ArquivoDeEntrada\"");		
	} 
		
        int algoritmo_a_executar = Integer.parseInt(args[0]);
        ArrayList<Integer> valores_extraidos_arquivo = readFile(args[1]);
        
        switch (algoritmo_a_executar) {
            case 1:
                System.out.println("---------------------------- \n Executando insertionSort \n----------------------------");
                InsertionSort.insertionSortAlgoritmo(valores_extraidos_arquivo);
                
                for(int n : valores_extraidos_arquivo){
                    System.out.println(n);
                }
                break;  
            case 2:
                System.out.println("---------------------------- \n Executando selectionSort \n----------------------------");
                SelectionSort.selectionSortAlgoritmo(valores_extraidos_arquivo);
		
                for(int n : valores_extraidos_arquivo){
                    System.out.println(n);
                }
                break;
            case 3:
                System.out.println("---------------------------- \n Executando mergeSort \n----------------------------");
                ArrayList<Integer> auxiliar = new ArrayList<Integer> ();
                MergeSort.mergeSortAlgoritmo(valores_extraidos_arquivo, auxiliar, 0, valores_extraidos_arquivo.size()-1);

                for(int n : valores_extraidos_arquivo){
                    System.out.println(n);
                }
                break;
            case 4:
                System.out.println("---------------------------- \n Executando quickSort \n----------------------------");
                QuickSort.quickSortAlgoritmo(valores_extraidos_arquivo, 0, valores_extraidos_arquivo.size()-1);
                
                for(int n : valores_extraidos_arquivo){
                    System.out.println(n);
                }
                break;
        }
    }
    
}