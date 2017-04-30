package processing;

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

    public static boolean[] convert(Character[] originalArray, boolean[] newArray) {
        
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
        
        return newArray;
        
    }
    
}
