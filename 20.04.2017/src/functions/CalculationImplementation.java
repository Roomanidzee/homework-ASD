package functions;

import interfaces.CalculationInterface;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class CalculationImplementation implements CalculationInterface{

    @Override
    public double[][] addition(double[][] array1, double[][] array2) throws ArrayIndexOutOfBoundsException {
        
        if((array1.length != array2.length) || ((array1.length % 2 != 0) ||(array2.length % 2 != 0)))
        {
            
            throw new ArrayIndexOutOfBoundsException("Матрицы должны быть квадратными, "
                    + "одинакового размера");
            
        }
        
        int size = array1.length;
        
        double[][] newArray = new double[size][size];
        
        for(int i = 0; i < newArray.length; i++){
            
            for(int j = 0; j < newArray[i].length; j++){
                
                newArray[i][j] = array1[i][j] + array2[i][j];
                
            }
        }
        
        return newArray;
        
    }

    @Override
    public double[][] substraction(double[][] array1, double[][] array2) throws ArrayIndexOutOfBoundsException {
       
        if((array1.length != array2.length) || ((array1.length % 2 != 0) ||(array2.length % 2 != 0)))
        {
            
            throw new ArrayIndexOutOfBoundsException("Матрицы должны быть квадратными, "
                    + "одинакового размера");
            
        }
        
        int size = array1.length;
        
        double[][] newArray = new double[size][size];
        
        for(int i = 0; i < size; i++){
            
            for(int j = 0; j < size; j++){
                
                newArray[i][j] = array1[i][j] - array2[i][j];
                
            }
            
        }
        
        return newArray;
        
    }

    @Override
    public double[][] multiply(double[][] array1, double[][] array2)throws ArrayIndexOutOfBoundsException {
        
        ArrayChangerImplementation change = new ArrayChangerImplementation();
        
        int k1 = 0;
        int k2 = 0;
        
        for(int i = 0; i < array1[i].length; i++){
            
            k1++;
            
            for(int j = 0; j <= array2[j].length; j++){
                
                k2++;
                
            }
            
        }
        
        if(k1 != k2){
            
            throw new ArrayIndexOutOfBoundsException("Количество строк в первой "
                    + "матрице не равно количеству столбцов во второй матрице");
            
        }
        
        int size = array1.length;
        
        double[][] newArray = new double[size][size];
        
        double[][] x11 = change.getNewArray(array1, 0, array1.length / 4);
        double[][] x12 = change.getNewArray(array1, array1.length / 4, array1.length / 2);
        double[][] x21 = change.getNewArray(array1, array1.length / 2, 3 * array1.length / 4);
        double[][] x22 = change.getNewArray(array1, 3 * array1.length / 4, array1.length);
        
        double[][] y11 = change.getNewArray(array2, 0, array2.length / 4);
        double[][] y12 = change.getNewArray(array2, array2.length / 4, array2.length / 2);
        double[][] y21 = change.getNewArray(array2, array2.length / 2, 3 * array2.length / 4);
        double[][] y22 = change.getNewArray(array2, 3 * array2.length / 4, array2.length);
        
        double[][] p1 = multiply(x11, substraction(y21, y22));
        double[][] p2 = multiply(addition(x11, x12), y22);
        double[][] p3 = multiply(addition(x21, x22), y11);
        double[][] p4 = multiply(x22, substraction(y21, y11));
        double[][] p5 = multiply(addition(x11, x22), addition(y11, y22));
        double[][] p6 = multiply(substraction(x12, x22), addition(y21, y22));
        double[][] p7 = multiply(substraction(x11, x21), addition(y11, y12));
        
        double[][] result1 = substraction(addition(p5, p4), addition(p2, p6));
        double[][] result2 = addition(p1, p2);
        double[][] result3 = addition(p3, p4);
        double[][] result4 = substraction(addition(p1, p5), substraction(p3, p7));
        
        for(int i = 0; i < newArray.length / 4 ; i++){
            
            System.arraycopy(result1[i], 0, newArray[i], 0, newArray.length / 4);
            
        }
        
        for(int i = newArray.length / 4; i < newArray.length / 2; i++){
            
            System.arraycopy(result2[i], newArray.length / 4, newArray[i],
                     newArray.length / 4, newArray.length / 2);
            
        }
        
        for(int i = newArray.length / 2; i < 3 * newArray.length /4; i++){
            
            System.arraycopy(result3[i], newArray.length / 2, 
                    newArray[i], newArray.length / 2, 3 * newArray.length /4);
            
        }
        
        for(int i = 3 * newArray.length / 4; i < newArray.length; i++){
            
            System.arraycopy(result4[i],3 * newArray.length / 4, 
                    newArray[i], 3 * newArray.length / 4, newArray.length);
            
        }
        
        return newArray;
        
    }
    
}
