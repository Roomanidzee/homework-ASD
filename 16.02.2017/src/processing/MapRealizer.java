package processing;

import interfaces.MapInterface;
import java.util.Arrays;
/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class MapRealizer implements MapInterface{
    
    
    private String[] keyArray;
    private Object[] valueArray;
    
    private int size1 = 0;
    private int size2 = 0;
    
    public MapRealizer(){
        
        this.keyArray = new String[20];
        this.valueArray = new Object[20];
        
    }
    
    @Override
    public void add(String key, Object value) {
        
        for(int i = 0; i < this.size1; i++){
            
            if(this.keyArray[i].equals(key)){
                
                throw new IllegalArgumentException("You already have the same key");
                
            }
            
        }
        
        if(this.keyArray.length - this.size1 <= 10
           && this.valueArray.length - this.size2 <= 10){
            
            increaseArraySize();
            
        }
        
        this.keyArray[this.size1] = key;
        this.valueArray[this.size2] = value;
        this.size1++;
        this.size2++;
        
    }
    
    
    private void increaseArraySize(){
        
        this.keyArray = Arrays.copyOf(this.keyArray, this.keyArray.length * 2);
        this.valueArray = Arrays.copyOf(this.valueArray, this.valueArray.length * 2);
        
    }

    @Override
    public Object remove(String key) {
        
        int index = 0;
        int k = 0;
        
        for(int i = 0; i < this.size1; i++){
            
            if(this.keyArray[i].equals(key)){
                
                index = i;
                break;
                
            }else{
                
                k++;
                
            }
            
            if(k == i){
                
                throw new NullPointerException("No such key");
                
            }
            
        }
        
        Object obj = this.valueArray[index];
        this.keyArray[index] = null;
        this.valueArray[index] = null;
        int temp = index;
        
        while(temp < this.size1 && temp < this.size2){
            
            this.keyArray[temp] = this.keyArray[temp + 1];
            this.keyArray[temp + 1] = null;
            
            this.valueArray[temp] = this.valueArray[temp + 1];
            this.valueArray[temp + 1] = null;
            
            temp++;
            
        }
        
        this.size1--;
        this.size2--;
        
        return obj;
        
    }

    @Override
    public Object get(String key) {
        
        int index = 0;
        int k = 0;
        
        for(int i = 0; i < this.size1; i++){
            
            if(this.keyArray[i].equals(key)){
                
                index = i;
                break;
                
            }else{
                
                k++;
                
            }
            
            if(k == i){
                
                throw new NullPointerException("No such key");
                
            }
            
        }
        
        return this.valueArray[index];
        
    }

    @Override
    public void set(String key, Object value) {
        int index = 0;
        int k = 0;
        
        for(int i = 0; i < this.size1; i++){
            
            if(this.keyArray[i].equals(key)){
                
                index = i;
                break;
                
            }else{
                
                k++;
                
            }
            
            if(k == i){
                
                throw new NullPointerException("No such key");
                
            }
            
        }
        
        this.valueArray[index] = value;
    }

    @Override
    public void removeAll() {
       
        this.size1 = 0;
        this.size2 = 0;
        
    }

    @Override
    public String[] getKeys() {
        
        String[] newKeyArray = new String[this.size1];
        
        System.arraycopy(this.keyArray, 0, newKeyArray, 0, this.size1);
        
        return newKeyArray;
        
    }

    @Override
    public Object[] getValues() {
     
        Object[] newValueArray = new Object[this.size2];
        
        System.arraycopy(this.valueArray, 0, newValueArray, 0, this.size2);
        
        return newValueArray;
        
    }

    @Override
    public int size() {
        
        return this.size1;
        
    }
    
    
    
}
