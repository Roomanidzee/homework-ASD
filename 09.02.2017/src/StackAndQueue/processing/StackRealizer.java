package StackAndQueue.processing;

import StackAndQueue.interfaces.StackInterface;
import java.util.Arrays;

/**
 *
 * @author Андрей Романов
 */
public class StackRealizer implements StackInterface{
    
    private Object[] objArray;
    private int size = 0;
    private Object variable;
    
    public StackRealizer(){
        
        this.objArray = new Object[20];
        
    }
    
    @Override
    public void add(Object obj){
        
        if(this.objArray.length - this.size <= 10){
            
            increaseArraySize();
            
        }
        
        this.objArray[this.size] = obj;
        this.size++;
        
    }
    
    public void increaseArraySize(){
        
        this.objArray = Arrays.copyOf(this.objArray, this.objArray.length * 2);
        
    }
    
    public boolean isEmpty(){
        
        return this.size == 0;
        
    }
    
    @Override
    public int size(){
        
        return this.size;
        
    }
    
    @Override
    public Object pop(){
        
        if(!isEmpty()){
            
            this.variable = this.objArray[this.size - 1];
            this.objArray[this.size - 1] = null;
            this.size--;
            return this.variable;
        
        }else{
            
           throw new NullPointerException("There are no elements in Stack");
           
        }
        
    }
    
    @Override
    public Object peek(){
        
        if(!isEmpty()){
            
            return this.objArray[this.size - 1];
            
        }else{
            
           throw new NullPointerException("There are no elements in Stack");
           
        }
        
        
    }
}
