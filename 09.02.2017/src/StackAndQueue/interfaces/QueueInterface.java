package StackAndQueue.interfaces;

/**
 *
 * @author Андрей Романов
 */
public interface QueueInterface {
    
    void add(Object obj);
    Object pop();//returns first element in queue, deletes it
    Object peek();//return first element in queue, shows it 
    int size();
    
}
