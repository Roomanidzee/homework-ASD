package sorting_functions;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class MergeSort {
    
    private static int[] sortArray;
    private static int[] tempArray;
    
    public static void sort(int[] array){
        
        sortArray = array;
        tempArray = new int[array.length];
        merge(0, array.length - 1);
        
    }
    
    private static void merge(int low, int high){
        
        if(low < high){
            
            int middle = low + (high - low) / 2;
            
            merge(low, middle);
            merge(middle + 1, high);
            mergeParts(low, middle, high);
            
        }
        
    }
    
    private static void mergeParts(int low, int middle, int high){
        
        for(int i = low; i <= high; i++){
            
            tempArray[i] = sortArray[i];
            
        } 
        
        int i = low;
        int j = middle + 1;
        int k = low;
        
        while(i <= middle && j <= high){
            
            if(tempArray[i] <= tempArray[j]){
                
                sortArray[k] = tempArray[i];
                i++;
                
            }else{
                
                sortArray[k] = tempArray[j];
                j++;
                
            }
            
            k++;
            
        }
        
        while(i <= middle){
            
            sortArray[k] = tempArray[i];
            k++;
            i++;
            
        }
    }
}
