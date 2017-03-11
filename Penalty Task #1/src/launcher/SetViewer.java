package launcher;

import implementation.SetImplementation;
import java.util.Arrays;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class SetViewer {
    
    public static void main(String[] args){
        
        SetImplementation<Integer> set1 = new SetImplementation<>();
        SetImplementation<Integer> set2 = new SetImplementation<>();
        
        for(int i = 0; i < 15; i+=2){
            
            set1.add(i);
            set2.add(i);
            
        }        
        
        set1.remove(2);   
        
        Integer[] array1 = new Integer[set1.size()];
        
        System.out.println(Arrays.toString(set1.toArray(array1)));        
        
    }
    
}
