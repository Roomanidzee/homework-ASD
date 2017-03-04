package entries;

import java.util.Iterator;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class Entry<E> {
    
    private Entry<E> next;//переменные для работы с данными
    private E data;
    
    public Entry(){}
    
    public Entry(E data, Entry<E> next){
        
        this.data = data;
        this.next = next;
        
    }
    
     public MyIterator<E> iterator(){
        
        return new MyIterator();
        
    }
    
    private class MyIterator<E>{
        
         private Entry<E> current;//точка доступа на данный момент 
        
         public boolean hasNext() {
             
                return this.current != null;
                
         }

   
         public E next() {
              
             if(!hasNext()){
                 
                 throw new NullPointerException("No such entry");
                 
             }
             
             return (E) current.getEntry();
             
         }
        
    }
    
    public void setEntry(Entry<E> nextEntry){
        
        this.next = nextEntry;
        
    }
    
    public Entry<E> getEntry(){
        
        return next;
        
    }
    
    public void setData(E entryData){
        
        this.data = entryData;
        
    }
    
    public E getData(){
        
        return data;
        
    }
    
}
