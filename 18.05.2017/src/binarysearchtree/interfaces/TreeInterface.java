package binarysearchtree.interfaces;

import binarysearchtree.entities.Node;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T> value
 */
public interface TreeInterface<T> {
    
    Node<T> findByKey(int key);
    Node<T> findMin();
    Node<T> add(int key, T value);
    Node<T> remove(int key, T value);
    
}
