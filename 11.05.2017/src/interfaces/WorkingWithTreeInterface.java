package interfaces;

import entities.Tree;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1> key
 * @param <T2> value
 */
public interface WorkingWithTreeInterface<T1, T2> {
    
    void addingNodesToTree(Tree<T1, T2> tree, T1 key, T2 value);
    void removeNodesFromTree(Tree<T1, T2> tree, T1 key);
    String getNodeFromTree(Tree<T1, T2> tree, T1 key);
    
}
