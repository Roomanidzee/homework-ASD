package binarysearchtree.interfaces;

import binarysearchtree.entities.Node;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T> value
 */
public interface NodeInterface<T> {
    
    Node<T> findByKey(int key, Node<T> node);
    Node<T> findMin(Node<T> node);
    Node<T> findMax(Node<T> node);
    Node<T> addNode(Node<T> node, Node<T> newNode);
    Node<T> removeNode(Node<T> node, Node<T> newNode);
    
}
