package sorting_functions;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class InsertionSort {
    
    public static void sort1(int[] array){
        //сложность O(n*n)
        int temp, i, j;
        
        for(i = 1; i < array.length; i++){
            
            temp = array[i];
            
            for(j = i - 1; j >= 0 && array[j] > temp; j--){
                
                array[j + 1] = array[j];
                
            }
            
            array[j + 1] = temp;
            
        }
        
    }
    
    public static void sort2(int[] array){
        //Сложность O(n * log n)
        int temp, j;
        
        for(int i = 0; i < array.length - 1; i++){
            
            if(array[i] > array[i + 1]){
                
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while(j > 0 && temp < array[j - 1]){
                    
                    array[j] = array[j - 1];
                    j--;
                    
                }
                
                array[j] = temp;
                
            }
            
        }
        
    }
    
}
