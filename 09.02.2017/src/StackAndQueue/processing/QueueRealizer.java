package StackAndQueue.processing;

import StackAndQueue.interfaces.QueueInterface;
import java.util.Arrays;

/**
 *
 * @author Андрей Романов
 */
public class QueueRealizer implements QueueInterface {
    
    private Object[] objArray;
    private int size = 0;
    private int index = 0;
    private Object variable;
    
    public QueueRealizer(){
        
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
            
             this.variable = this.objArray[this.index];
             this.objArray[this.index] = null;
             this.size--;
             this.index++;
             return this.variable;
             
        }else{
            
           throw new NullPointerException("There are no elements in Queue");
           
        }
                
    }
    
    @Override
    public Object peek(){
        
        if(!isEmpty()){
            
            return this.objArray[this.index];
            
        }else{
            
           throw new NullPointerException("There are no elements in Queue");
           
        }
        
        
    }
}
