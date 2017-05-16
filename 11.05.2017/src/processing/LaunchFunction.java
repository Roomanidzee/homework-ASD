package processing;

import entities.Tree;
import functions.WorkingWithTreeImpl;
import java.util.Scanner;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class LaunchFunction {
    
    private static final int LIMIT = 0;
    
    public static void launch(){
        
        Tree<Integer, Integer> simpleTree = new Tree<>();
        WorkingWithTreeImpl<Integer, Integer> treeWorker = new WorkingWithTreeImpl<>();
        
        System.out.println("Построенное дерево: ");
        
        Scanner sc = new Scanner(System.in);
        
        Integer key = sc.nextInt();
        Integer value = sc.nextInt();
        
        while(key != LIMIT && value != LIMIT){
            
            treeWorker.addingNodesToTree(simpleTree, key, value);
            
            key = sc.nextInt();
            value = sc.nextInt();
            
        }
        
        System.out.println(simpleTree.toString());
        
    }
    
}
