package processing;

import java.util.Arrays;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class BinaryNumber {
    //сущность двоичного числа для работы с ним
    private boolean[] array;
    
    public BinaryNumber(BinaryNumber number){
        
        this.array = number.getArray();
        
    }
    
    public BinaryNumber(boolean[] array){
        
        this.array = array;
        
    }
    
    public BinaryNumber(int number){
        
        String binary = Integer.toBinaryString(number);
        
        boolean[] newArray = new boolean[binary.length()];
        
        char[] binaryArray = binary.toCharArray();

        NumberUtils.convert(binaryArray, newArray);
        
        this.array = newArray;
        
    }
    
    public void setArray(boolean[] array){
        
        this.array = array;
        
    }
    
    public boolean[] getArray(){
        
        return this.array;
        
    }
    
    @Override
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < this.array.length; i++){
            
            sb.append(this.array[i]);
            
        }
        
        String binary = sb.toString();
        
        binary = binary.replaceAll("true", "1");
        binary = binary.replaceAll("false", "0");
        
        return binary;
        
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            
            return false;
            
        }
        
        if(!(obj instanceof BinaryNumber)){
            
            return false;
            
        } 
        
        BinaryNumber other = (BinaryNumber) obj;
        
        return Arrays.equals(this.getArray(), other.getArray());
        
    }

    @Override
    public int hashCode() {
        
        int hash = 3;
        
        hash = 79 * hash + Arrays.hashCode(this.array);
        
        return hash;
        
    }
    
    
}
