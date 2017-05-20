package homecontrolwork.interfaces;

import homecontrolwork.entities.Node;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public interface NodeInterface {
    
    Node merge(Node left, Node right);
    void split(int key, Node left, Node right);
    Node insert(Node node);
    Node remove(Node node); 
    Node get(int key);
    
}
