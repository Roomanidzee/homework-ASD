package binarynumber.processing;

import binarynumber.interfaces.CalculationsInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class CalculationsImpl implements CalculationsInterface{
    
    private final NumberUtils utils = new NumberUtils();
    
    @Override
    public BinaryNumber addTo(BinaryNumber first, BinaryNumber second) {
        
        boolean[] firstArray = first.getArray();
        boolean[] secondArray = second.getArray();
        
        boolean[] result = null;
        
        if(firstArray.length > secondArray.length ||
                firstArray.length == secondArray.length){
            
            result = add(firstArray, secondArray);
            
        }
        
        if(secondArray.length > firstArray.length){
            
            result = add(secondArray, firstArray);
            
        }
        
        return new BinaryNumber(result);       
        
    }
    
    private boolean[] add(boolean[] first, boolean[] second){
        
        boolean[] newSecond = this.utils.getNewArray(first, second);
        
        boolean[] result = new boolean[first.length];
        
        for(int i = result.length - 1; i > 0; i--){
            
            if(first[i] && newSecond[i]){
                
                result[i] = false;
                result[i - 1] = true;
                i -= 2;
                
            }else{
                
                result[i] = first[i] && newSecond[i];
                
            }
            
        }
        
        return result;
        
    }

    @Override
    public BinaryNumber subtractTo(BinaryNumber first, BinaryNumber second) {
        
        boolean[] firstArray = first.getArray();
        boolean[] secondArray = second.getArray();
        
        boolean[] result = null;
        
        if(firstArray.length > secondArray.length ||
                firstArray.length == secondArray.length)
        {
            
            result = subtract(firstArray, secondArray);
            
        }
        
        if(firstArray.length < secondArray.length){
            
            result = subtract(secondArray, firstArray);
            
        }
        
        return new BinaryNumber(result);
        
    }
    
    private boolean[] subtract(boolean[] first, boolean[] second){
        
        boolean[] newSecond = this.utils.getNewArray(first, second);
        
        boolean[] result = new boolean[first.length];
        
        for(int i = result.length - 1; i > 0; i--){
            
            if(!first[i] & !newSecond[i] || first[i] & newSecond[i]){
                
                result[i] = false;
                
            }
            
            if(first[i] & !newSecond[i]){
                
                result[i] = true;
                
            }
        }
        
        return result;
        
    }
    
    @Override
    public BinaryNumber multiplyTo(BinaryNumber first, BinaryNumber second) {
        
        boolean[] firstArray = first.getArray();
        boolean[] secondArray = second.getArray();
        
        if(firstArray == null || secondArray == null){
            
            return null;
            
        }
        
        int k1 = 0;
        int k2 = 0;
        
        for(int i = 0; i < firstArray.length; i++){
            
            if(!firstArray[i]){
                
                k1++;
                
            }
            
        }
        
        for(int i = 0; i < secondArray.length; i++){
            
            if(!secondArray[i]){
                
                k2++;
                
            }
            
        }
        
        if(k1 == firstArray.length || k2 == secondArray.length){
            
            Arrays.fill(firstArray, false);
            
            return new BinaryNumber(firstArray);
            
        }       
        
        String rightNumber = second.toString();
        
        String newRightNumber = Integer.toBinaryString(Integer.parseInt(rightNumber, 2) >> 1);
        
        char[] newRightNumberArray = newRightNumber.toCharArray();
        
        boolean[] againRightNumber = new boolean[newRightNumberArray.length];
        
        NumberUtils.convert(newRightNumberArray, againRightNumber);
        
        boolean[] z = multiply(firstArray, againRightNumber);
        
        BinaryNumber result = null;
        
        if(Integer.parseInt(newRightNumber, 2) % 2 == 0){
            
            result = new BinaryNumber(z);
            
        }else{
            
            BinaryNumber temp1 = new BinaryNumber(z);
            
            String temp2 = Integer.toBinaryString(
                                   Integer.parseInt(temp1.toString(), 2) << 1);
            
            char[] temp2Array = temp2.toCharArray();
            
            boolean[] againTemp = new boolean[temp2Array.length];
            
            NumberUtils.convert(temp2Array, againTemp);
            
            result = new BinaryNumber(
                    addTo(new BinaryNumber(firstArray), new BinaryNumber(againTemp)));
            
        }
        
        return result;
        
    }
    
    private boolean[] multiply(boolean[] first, boolean[] second){
        
        int limit = second.length;
        
        List<List<Boolean>> rowsList = new ArrayList<>(limit);
        
        int current = second.length - 1;
        
        List<Boolean> current1 = new ArrayList<>();
        List<Boolean> current2 = new ArrayList<>();
        List<Boolean> current3 = new ArrayList<>();
        List<Boolean> current4 = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            
            current1.add(false);
            
        }
        
        for(int i = 0; i < first.length; i++){
            
            current1.add(first[i] & second[current]);
            
        }
        
        rowsList.add(current1);
        current--;
        
        for(int i = 0; i < 3; i++){
            
            current2.add(false);
            
        }
        
        for(int i = 0; i < first.length; i++){
            
            current2.add(first[i] & second[current]);
            
        }
        
        current2.add(false);
        current2.add(false);
        
        rowsList.add(current2);
        current--;
        
        current3.add(false);
        
        for(int i = 0; i < first.length; i++){
            
            current3.add(first[i] & second[current]);
            
        }
        
        for(int i = 0; i < 3; i++){
            
            current3.add(false);
            
        }
        
        rowsList.add(current3);
        current--;
        
        for(int i = 0; i < first.length; i++){
            
            current4.add(first[i] & second[current]);
            
        }
        
        rowsList.add(current4);
        
        Boolean[] array1 = new Boolean[8];
        Boolean[] array2 = new Boolean[8];
        Boolean[] array3 = new Boolean[8];
        Boolean[] array4 = new Boolean[8];
        
        rowsList.get(0).toArray(array1);
        rowsList.get(1).toArray(array2);
        rowsList.get(2).toArray(array3);
        rowsList.get(3).toArray(array4);
        
        boolean[] newArray1 = new boolean[8];
        boolean[] newArray2 = new boolean[8];
        boolean[] newArray3 = new boolean[8];
        boolean[] newArray4 = new boolean[8];
        
        for(int i = 0; i < 8; i++){
            
            newArray1[i] = array1[i];
            newArray2[i] = array2[i];
            newArray3[i] = array3[i];
            newArray4[i] = array4[i];
            
        }
        
        return add(add(newArray1, newArray2), add(newArray3, newArray4));
        
    }
    
}
