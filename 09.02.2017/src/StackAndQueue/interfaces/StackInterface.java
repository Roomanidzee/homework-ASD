package StackAndQueue.interfaces;

/**
 *
 * @author Андрей
 */
public interface StackInterface {
    
    void add(Object obj);
    Object pop();//returns last element in stack, deletes it
    Object peek();//returns last element in stack, shows it
    int size();
    
}
