package binarysearchtree.processing;

import binarysearchtree.entities.Tree;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class LaunchFunction {
    
    public static void launch(){
        
        Tree<Integer> binaryTree = new Tree<>();
        
        binaryTree.add(2, 3);
        binaryTree.add(3, 4);
        binaryTree.add(4, 5);
        
        //System.out.println("Исходное дерево: ");
        
        //System.out.println(binaryTree.toString());
        
        //System.out.println();
        
        binaryTree.remove(2, 3);
        
        //System.out.println("Измененное дерево: ");
        
        //System.out.println(binaryTree.toString());
        
        //System.out.println();
        
    }
    
}
