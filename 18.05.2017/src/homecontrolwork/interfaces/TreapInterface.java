package homecontrolwork.interfaces;

import homecontrolwork.entities.Node;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public interface TreapInterface {
    
    Node merge(Node left, Node right);
    void split(int key);
    Node insert(int key);
    Node remove(int key);
    int getTreapSize();
    Node get(int key);
    
}
