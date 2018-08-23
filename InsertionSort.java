import java.util.ArrayList;

public class InsertionSort {
    /*********************************************************************************
     * Método insertionSort
    *********************************************************************************/
    public static void insertionSortAlgoritmo(ArrayList<Integer> vetor) {
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
}
