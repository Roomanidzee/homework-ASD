package implementation;
//все импорты, которые нужны
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class SetImplementation<E> implements Set<E> {
    
    private E[] valueArray;
    private int size = 0;
    
    public SetImplementation(){
        
        this.valueArray = (E[]) new Object[20];
        
    }
    
    private void increaseArraySize(){
        //увеличение размера массива в случае нехватки места
        this.valueArray = Arrays.copyOf(this.valueArray, this.valueArray.length * 2);
        
    }
    
    private class MyIterator<E> implements Iterator<E>{
        //реализация итератора
        private int current = 0;
        private E value;
        
        @Override
        public boolean hasNext() {
            
            return this.current < size;
            
        }

        @Override
        public E next() {
            
            if(!hasNext()){
                
                throw new NoSuchElementException("No such element");
                
            }
            
            this.value = (E) valueArray[this.current];
            this.current++;
            return this.value;
            
        }
        
        @Override
        public void remove(){
            
            valueArray[this.current] = null;
            int temp = current;
        
            while(temp < size){
            
                valueArray[temp] = valueArray[temp + 1];
                valueArray[temp + 1] = null;
            
                temp++;
            
            }
        
            size--;
            
        }
        
    }    
    
    @Override
    public int size() {
        //возвращает размер коллекции
        return this.size;
        
    }

    @Override
    public boolean isEmpty() {
        //проверка на наличие элементов
        return this.size == 0;
        
    }

    @Override
    public boolean contains(Object o) {
        //проверка на существование определенного элемента
        if(o == null){
            
            throw new NullPointerException("There are no null objects "
                    + "in tnis collection");
            
        }
        
        Iterator<E> iter = iterator();
        
        while(iter.hasNext()){
            
            return iter.next().equals(o);
            
        }
        
        return false;
        
    }

    @Override
    public Iterator<E> iterator() {
        
        return new MyIterator();
        
    }

    @Override
    public Object[] toArray() {
        //перевод в массив
        Iterator<E> iter = iterator();
        
        Object[] array = new Object[size()];
        
        while(iter.hasNext()){
            
            for(int i = 0; i < array.length; i++){
            
                  array[i] = iter.next();
            
            }
            
        }
        
        return array;
        
    }

    @Override
    public <T> T[] toArray(T[] a) {
       
        //превращает коллекцию в массив определенного типа 
       if(a == null){
           
           throw new NullPointerException("Specified array can't be null");
           
       }
       
       if(!a.getClass().isArray()){
           
           throw new ArrayStoreException("You can't store elements there");
           
       }
       
       Iterator<E> iter = iterator();
       
       while(iter.hasNext()){
       
            for(int i = 0; i < a.length; i++){
           
                    a[i] = (T) iter.next();
                
               }    
           
       }
        
       return a;
        
    }

    @Override
    public boolean add(E e) {
        //добавление элемента
        if(contains(e)){
            
            throw new IllegalStateException("You can't add equal elements in "
                    + "this collecion");
            
        }
        
         if(this.valueArray.length - this.size <= 10){
            
            increaseArraySize();
            
        }
        
        this.valueArray[this.size] = e;
        this.size++;
        return true;
        
    }

    @Override
    public boolean remove(Object o) {
        //удаление элемента
        if(o == null){
            
            throw new NullPointerException("There are no null elements in this collection");
            
        }
        
        int index = 0;
        int k = 0;
        
        for(int i = 0; i < size(); i++){
            
            if(this.valueArray[i].equals(o)){
                
                index = i;
                break;
                
            }else{
                
                k++;
                
            }
            
        }
        
        if(k == size()){
            
            throw new NullPointerException("No such element");
            
        }
        
        this.valueArray[index] = null;
        int temp = index;
        
        while(temp < size()){
            
            this.valueArray[temp] = this.valueArray[temp + 1];
            this.valueArray[temp + 1] = null;
            
            temp++;
            
        }
        
        this.size--;
        
        return true;
        
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //проверка на наличие элементов
        Iterator<?> iter1 = c.iterator();
        
        while(iter1.hasNext()){
            
            if(iter1.next() == null){
                
                throw new NullPointerException("You can't check collection "
                        + "with null elements");
                
            }
            
        }
        
        Iterator<?> iter2 = c.iterator();
        
        int k = 0;
        
        while(iter2.hasNext()){
            
            if(contains(iter2.next())){
                
                k++;
                
            }
            
        }
        
        return k == c.size();
        
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //сливание коллекций
        Iterator<? extends E> iter1 = c.iterator();
        
        while(iter1.hasNext()){
            
            if(contains(iter1.next())){
                
                throw new IllegalStateException("You can't add equal elements in "
                    + "this collecion");
                
            }
            
        }
        
        Iterator<? extends E> iter2 = c.iterator();
        
        while(iter2.hasNext()){
            
            add(iter2.next());
            
        }
        
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        //удаление элементов, которых нет в исходной коллекции
        Iterator<?> iter1 = (Iterator<E>) c.iterator();
        
        while(iter1.hasNext()){
            
            if(iter1.next() == null){
                
                throw new NullPointerException("You can't remove collection "
                        + "with null elements");
                
            }
            
        }
        
        Iterator<?> iter2 = c.iterator();
        
        E temp;
        
        while(iter2.hasNext()){
            
            temp = (E) iter2.next();
            
            if(!contains(temp)){
                
                remove(temp);
                
            }
            
        }
        
        return true;
        
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        
        Iterator<?> iter1 = (Iterator<E>) c.iterator();
        
        while(iter1.hasNext()){
            
            if(iter1.next() == null){
                
                throw new NullPointerException("You can't remove collection "
                        + "with null elements");
                
            }
            
        }
        
        Iterator<?> iter2 = c.iterator();
        
        E temp;
        
        while(iter2.hasNext()){
            
            temp = (E) iter2.next();
            
            if(contains(temp)){
                
                remove(temp);
                
            }
        
        }
        
        return true;
    }    

    @Override
    public void clear() {
        //очистка коллекции
        this.size = 0;
        this.valueArray = null;
        
    }
    
    @Override
    public boolean equals(Object obj){
        //проверка на равенство
        if(obj != null){
            
             
            if(!(obj instanceof Collection<?>)){
            
                 return false;
            
            } else {
            
                Collection<E> c = (Collection<E>)obj; 
                
                Iterator<E> iter1 = c.iterator();
                Iterator<E> iter2 = iterator();
                
                int k = 0;
                
                while(iter1.hasNext() && iter2.hasNext()){
                    
                    if (iter1.next().equals(iter2.next())){
                        
                        k++;
                        
                    }
                    
                }
                
                return k == size();
            }      
            
        } else {
            return false;
        }
        
    }

    @Override
    public int hashCode() {
        //генерация хэш-кода
        int hash = 7;
        hash = 19 * hash + Arrays.deepHashCode(this.valueArray);
        hash = 19 * hash + this.size;
        return hash;
        
    }
}
