package interfaces;

import entities.Tree;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1> key
 * @param <T2> value
 */
public interface BypassInterface<T1, T2> {
    
    void widthBypass(Tree<T1, T2> tree, T1 value, boolean[] usedNode);
    void depthBypass(Tree<T1, T2> tree, T1 value, boolean[] usedNode);
    
}
