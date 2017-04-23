package functions;

import interfaces.ArrayChangerInterface;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class ArrayChangerImplementation implements ArrayChangerInterface{

    @Override
    public double[][] getNewArray(double[][] originalArray, int begin, int end)
            throws ArrayIndexOutOfBoundsException 
    {
        
        if(originalArray.length % 2 != 0){
            
            throw new ArrayIndexOutOfBoundsException("Матрица на входе должна быть квадратной");
            
        }
        
        int size = 0;
        
        while(size != 4){
            
            size = originalArray.length / 4;
            
            begin /= 2;
            
            end /= 2;
        }
        
        double[][] newArray = new double[size][size];
        
        int count1, count2;
        
        count1 = 0;
        
        for(int i = begin; i < end; i++){
            
            count2 = 0;
            
            for(int j = begin; j < end; j++){
                
                newArray[count1][count2] = originalArray[i][j];
                count2++;
                
            }
            
            count1++;
            
        }
        
        return newArray;
        
    }
    
}
