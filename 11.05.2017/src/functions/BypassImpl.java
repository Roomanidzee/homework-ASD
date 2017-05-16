package functions;

import entities.Node;
import entities.Tree;
import interfaces.BypassInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1> key
 * @param <T2> value
 */
public class BypassImpl<T1, T2> implements BypassInterface<T1, T2> {

    @Override
    public void widthBypass(Tree<T1, T2> tree, T1 value, boolean[] usedNode) {
        
        WorkingWithTreeImpl<T1, T2> work = new WorkingWithTreeImpl<>();
        
        if(usedNode == null){
            
            Arrays.fill(usedNode, false);
            
        }      
        
        Queue<T1> queue = new LinkedList<>();
        
        Node<T1, T2> root = tree.getRoot();
        
        ArrayList<Node<T1, T2>> findableNode = (ArrayList<Node<T1, T2>>) root.getAllChildren();
        
        int index1 = 0;
        
        Node<T1, T2> workableNode = null;
        
        for(int i = 0; i < findableNode.size(); i++){
            
            if(findableNode.get(i).getValue().equals(value)){
                
                index1 = i;
                workableNode = findableNode.get(i);
                
            }
            
        }
        
        if(usedNode[index1]){
            
            System.out.println("Вершина уже помечена");
            
        }else{       
            
            queue.add(value);
            usedNode[index1] = true;            
            
            while(!queue.isEmpty()){
                
                value = queue.poll();
                System.out.println(work.getNodeFromTree(tree, value));
                
                for(int i = 0; i < workableNode.getChildrenCount(); i++){
                    
                    T1 key = workableNode.getChildren(i).getKey();
                    
                    if(usedNode[i]){
                        
                        continue;
                        
                    }
                    
                    queue.add(key);
                    usedNode[i] = true;
                    
                }
                
            }
            
        }
        
    }

    @Override
    public void depthBypass(Tree<T1, T2> tree, T1 value, boolean[] usedNode) {
        
        WorkingWithTreeImpl<T1, T2> work = new WorkingWithTreeImpl<>();
        
        if(usedNode == null){
            
            Arrays.fill(usedNode, false);
            
        }
        
        Node<T1, T2> root = tree.getRoot();
        
        ArrayList<Node<T1, T2>> findableNode = (ArrayList<Node<T1, T2>>) root.getAllChildren();
        
        int index1 = 0;
        
        Node<T1, T2> workableNode = null;
        
        for(int i = 0; i < findableNode.size(); i++){
            
            if(findableNode.get(i).getValue().equals(value)){
                
                index1 = i;
                workableNode = findableNode.get(i);
                
            }
            
        }
        
        if(usedNode[index1]){
            
            System.out.println("Вершина уже помечена");
            
        }else{
            
            usedNode[index1] = true;
            System.out.println(work.getNodeFromTree(tree, value));
            
        }
        
        for(int i = 0; i < workableNode.getChildrenCount(); i++){
            
            T1 key = workableNode.getChildren(i).getKey();
            
            depthBypass(tree, key, usedNode);
            
        }
        
    }
    
}
