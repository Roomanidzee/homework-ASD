package sorting_functions;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class CountingSort {
    
    private static int[] tempArray;
    
    private static final int K = 20;
    
    public static void sort(int[] array){
        
        tempArray = new int[K];
        
        for(int i = 0; i < K; i++){
            
            tempArray[i] = 0;
            
        }
        
        int b = 0;
        
        for(int i = 0; i < array.length; i++){
            
            tempArray[array[i]] += 1;
            b = 0;
            
        }
        
        
        
        for(int j = 0; j < K; j++){
            
            for(int i = 0; i < tempArray[j]; i++){
                
                array[b] = j;
                b += 1;
                
            }
        }
    }
}
