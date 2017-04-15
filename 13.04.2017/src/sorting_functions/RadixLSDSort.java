package sorting_functions;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class RadixLSDSort {
    
    public static void sort(int[] array){
        
        Queue<Integer>[] pockets = new Queue[10];
        
        for(int i = 0; i < 10; i++){
            
            pockets[i] = new LinkedList<>();
            
        }
        
        boolean sorted = false;
        int expo = 1;
        
        while(!sorted){
            
            sorted = true;
            
            for(int item : array){
                
                int pocket = (item / expo) % 10;
                
                if(pocket > 0){
                    
                    sorted = false;
                    
                }
                
                pockets[pocket].add(item);
            }
            
            expo *= 10;
            int index = 0;
            
            for(Queue<Integer> pocket1 : pockets){
                
                while(!pocket1.isEmpty()){
                    
                    array[index++] = pocket1.remove();
                    
                }                    
                
            }               
        }
    }
}    
