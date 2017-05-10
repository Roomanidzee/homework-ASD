package binarynumber.processing;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class NumberUtils {
    //полезные функции для работы с числами
    public static void convert(char[] originalArray, boolean[] newArray){
        
        if(originalArray.length != newArray.length){
            
            throw new ArrayIndexOutOfBoundsException("Массивы должны быть одинакового размера");
            
        }
        
        for(int i = 0; i < originalArray.length; i++){
            
            switch(originalArray[i]){
                
                case '0':
                    
                    newArray[i] = false;
                    break;
                
                case '1':
                    
                    newArray[i] = true;
                    break;
                
            }
            
        }
        
    }

    public boolean[] getNewArray(boolean[] first, boolean[] second){
        
        boolean[] newArray = new boolean[first.length];
        
        int limit = first.length - second.length;
        
        for(int i = 0; i < limit; i++){
            
            newArray[i] = false;
            
        }
        
        int count = 0;
        
        for(int i = limit; i < newArray.length; i++){
            
            newArray[i] = second[count];
            count++;
            
        }
        
        return newArray;
        
    }   
    
}
