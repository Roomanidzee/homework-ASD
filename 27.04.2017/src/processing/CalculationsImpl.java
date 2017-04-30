package processing;

import interfaces.CalculationsInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class CalculationsImpl implements CalculationsInterface{
    //реализция данного интерфейса
    @Override
    public BinaryNumber addTo(BinaryNumber first, BinaryNumber second) {
        
        char[] temp1 = first.toString().toCharArray();
        char[] temp2 = second.toString().toCharArray();
        
        char[] result = new char[temp1.length + 1];
        
        for(int i = result.length; i >= 0; i--){
            
            if(temp1[i] == '0' && temp2[i] == '0'){
                
                result[i] = '0';
                
            }
            
            if((temp1[i] == '0' && temp2[i] == '1')||(temp1[i] == '1' && temp2[i] == '0')){
                
                result[i] = '1';
                
            }
            
            if(temp1[i] == '1' && temp2[i] == '1'){
                
                result[i] = '0';
                result[i - 1] = '1';
                
            }
        }
        
        boolean[] resultNumber = new boolean[result.length];
        
        NumberUtils.convert(result, resultNumber);
        
        BinaryNumber total = new BinaryNumber(resultNumber);
        
        return total;
    }

    @Override
    public BinaryNumber multiplyTo(BinaryNumber first, BinaryNumber second) {
        
        char[] temp1 = first.toString().toCharArray();
        char[] temp2 = second.toString().toCharArray();
        
        int k = temp2.length;
        
        List<ArrayList<Character>> charArrays = new ArrayList<>(k);
        
        int count = k;
        
        for(int i = 0; i < k && count > 0; i++){
            
            ArrayList<Character> charArray = new ArrayList<>();
            
            for(int j = temp1.length; j > 0; j--){
                
                if(temp1[j] == '0' && temp2[count] == '0'){
                    
                    charArray.add('0');
                    
                }
                
                if(temp1[j] == '0' && temp2[count] == '1'){
                    
                    charArray.add('0');
                    
                }
                
                if(temp1[j] == '1' && temp2[count] == '0'){
                    
                    charArray.add('0');
                    
                }
                
                if(temp1[j] == '1' && temp2[count] == '1'){
                    
                    charArray.add('1');
                    
                }
            }
            
            charArrays.add(charArray);
            count--;
            
        }
        
        BinaryNumber result = null;
        BinaryNumber result1 = null;
        
        Character[] array1 = new Character[k];
        
        boolean[] number1 = new boolean[k];
        
        for(int i = 0; i < k; i++){
            
            charArrays.get(i).toArray(array1);
            
            result1.setArray(NumberUtils.convert(array1, number1));
            
            result = addTo(result, result1);
            
        }
        
        return result;
    }

    @Override
    public BinaryNumber subtractTo(BinaryNumber first, BinaryNumber second) {
        
        char[] temp1 = first.toString().toCharArray();
        char[] temp2 = second.toString().toCharArray();
        
        char[] result = new char[temp1.length + 2];
        
        for(int i = result.length; i > 0; i--){
            
            if(temp1[i] == '0' && temp2[i] == '0'){
                
                result[i] = '0';
                
            }
            
            if(temp1[i] == '1' && temp2[i] == '1'){
                
                result[i] = '0';
                
            }
            
            if(temp1[i] == '1' && temp2[i] == '0'){
                
                result[i] = '1';
                
            }
            
            if(temp1[i] == '0' && temp1[i - 1] == '1' && temp2[i] == '1'){
                
                result[i] = '1';
                
            }
        }
        
        boolean[] resultNumber = new boolean[result.length];
        
        NumberUtils.convert(result, resultNumber);
        
        BinaryNumber total = new BinaryNumber(resultNumber);
        
        return total;
        
    }

    @Override
    public BinaryNumber divideTo(BinaryNumber first, BinaryNumber second) {
        
        String num1 = first.toString();
        String num2 = second.toString();
        
        char[] result1 = null;
        char[] result2 = null;
        int k = 0;
        
        
        boolean[] number1 = null;
        boolean[] number2 = null;
        
        BinaryNumber total = null;
        
        if(Integer.parseInt(num1, 2) > Integer.parseInt(num2, 2)){
            
            number1 = new boolean[num1.length()];
            number2 = new boolean[num2.length()];
            
            result1 = num1.toCharArray();
            result2 = num2.toCharArray();
            
            NumberUtils.convert(result1, number1);
            NumberUtils.convert(result2, number2);
            
            total = subtractTo(new BinaryNumber(number1), new BinaryNumber(number2));
            
        }else{
            
            number1 = new boolean[num2.length()];
            number2 = new boolean[num1.length()];
            
            result1 = num2.toCharArray();
            result2 = num1.toCharArray();
            
            NumberUtils.convert(result1, number1);
            NumberUtils.convert(result2, number2);
            
            total = subtractTo(new BinaryNumber(number1), new BinaryNumber(number2));
            
        }
        
        return total;
        
    }
    
}
