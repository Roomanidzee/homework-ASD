package lists;

import entries.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class DoublyLinkedList<E>  {

   private Entry<E> head;
   private Entry<E> tail;
   
   private Entry<E> p;
   
   
   public void add(E data){
       //метод добавляет новый элемент
       this.p = new Entry<>();
       this.p.setData(data);       
       this.p.setEntry(this.head);
       this.tail = this.head;
       this.head = this.p;       
       
   }
   
    public void addAfter(Entry<E> p, E data){
        //добавление элемента после определенной точки
        if(p != null && p.getData() != null){
            
            p.setEntry(new Entry<>(data, p.getEntry()));
            
        }
        
    }
    
    private Iterator<E> findPrevious(E data){
        //найти предыдущий элемент
        Iterator<E> iter = (Iterator<E>) this.p.iterator();
        Entry<E> p1 = (Entry<E>) iter.next();
        
        while(iter.hasNext() && !p1.getData().equals(data)){
            
            iter = (Iterator<E>) iter.next();
            
            
        }
        
        return iter;
    }
    
    public void remove(E data){
        //удаление элемента
        Iterator iter = findPrevious(data);
        
        if(iter.hasNext()){
            
            this.p.setEntry((Entry<E>) iter.next());
            this.head = (Entry<E>) iter.next();
            this.tail = this.head;
            
        }
        
    }

    public boolean has(E data){
        //поиск элемента
        int k = 0;
        
        Iterator<E> iter = (Iterator<E>) this.p.iterator();
        Entry<E> p1 = (Entry<E>) iter.next();
        
        while(iter.hasNext() && !p1.getData().equals(data)){
            
            iter = (Iterator<E>) iter.next();
            k++;
            
        }
        
        return k == size();
        
    }  
    
    public int size(){
        //размер списка
        int count = 0;
        
        Iterator<E> iter = (Iterator<E>) this.p.iterator();
        while(iter.hasNext()){
            
            iter = (Iterator<E>) iter.next();
            count++;
            
        }
        
        return count;
        
    }
    
    public Entry<E> get(int index){
        //получение элемента по индексу
        if(index > size()){
            
            throw new NoSuchElementException("No such element");
            
        }
        
        int count = 0;
        
        Iterator<E> iter = (Iterator<E>) this.p.iterator();
        while(iter.hasNext() && count != index){
            
            iter = (Iterator<E>) iter.next();
            count++;
            
        }
        
        return (Entry<E>) iter;
    }
}    

