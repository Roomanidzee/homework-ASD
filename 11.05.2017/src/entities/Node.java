package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1>key
 * @param <T2>value
 */
public class Node <T1, T2>{
    
    private T1 key;
    private T2 value;
    private List<Node<T1, T2>> children;
    
    public Node(){
        
        this.children = new ArrayList<>();
        
    }

    @Override
    public int hashCode() {
        
        int hash = 5;
        
        hash = 31 * hash + Objects.hashCode(this.key);
        hash = 31 * hash + Objects.hashCode(this.value);
        hash = 31 * hash + Objects.hashCode(this.children);
        
        return hash;
        
    }
    
    @Override
    public boolean equals(Object obj){
        
        if(obj == null){
            
            return false;
            
        }
        
        if(!(obj instanceof Node)){
            
            return false;
            
        }
        
        Node<T1, T2> comparableNode = (Node<T1, T2>) obj;
        
        return (this.getKey().equals(comparableNode.getKey())
                && this.getValue().equals(comparableNode.getValue())
                && this.children.equals(comparableNode.getAllChildren()));
    }
    
    @Override
    public String toString(){
        
        return "{key = " + this.getKey() + " , value = " + this.getValue() + " }";
        
    }    
    
    public void setKey(T1 newKey){
        
        this.key = newKey;
        
    }
    
    public T1 getKey(){
        
        return this.key;
        
    }
    
    public void setValue(T2 newValue){
        
        this.value = newValue;
        
    }
    
    public T2 getValue(){
        
        return this.value;
        
    }
    
    public void addChildren(Node<T1, T2> child){
        
        this.children.add(child);
        
    }
    
    public Node<T1, T2> getChildren(int index){
        
        if(index > this.children.size() || index < 0){
            
            throw new IllegalArgumentException("Ошибочно введен индекс для поиска");
            
        }
        
        return this.children.get(index);
        
    }
    
    public void removeChildren(int index){
        
        if(index > this.children.size() || index < 0){
            
            throw new IllegalArgumentException("Ошибочно введен индекс для поиска");
            
        }
        
        this.children.remove(index);
        
    }
    
    public int getChildrenCount(){
        
        return this.children.size();
        
    }
    
    public List<Node<T1, T2>> getAllChildren(){
        
        return this.children;
        
    }
}
