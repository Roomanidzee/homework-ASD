package processing;

import functions.CalculationImplementation;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class LaunchFunction {
    
    public static void launch(){
        
        CalculationImplementation calc = new CalculationImplementation();
        Random r = new Random();
        
        double[][] array1 = new double[8][8];
        double[][] array2 = new double[8][8];
        
        int size = array1.length;
        
        for(int i = 0; i < size; i++){
            
            for(int j = 0; j < size; j++){
                
                array1[i][j] = r.nextDouble();
                array2[i][j] = r.nextDouble();
                
            }
            
        }
        
        double[][] resultArray = calc.multiply(array1, array2);
        
        System.out.println("Результат: " + Arrays.toString(resultArray));        
    }
    
}
