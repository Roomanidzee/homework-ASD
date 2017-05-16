package functions;

import entities.Node;
import entities.Tree;
import interfaces.WorkingWithTreeInterface;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1> key
 * @param <T2> value
 */
public class WorkingWithTreeImpl<T1, T2> implements WorkingWithTreeInterface<T1, T2>{

    @Override
    public void addingNodesToTree(Tree<T1, T2> tree, T1 key, T2 value) {
        
        Node<T1, T2> root = tree.getRoot();
        
        if (root == null){
            
            root = new Node<>();
            
            root.setKey(key);
            
            root.setValue(null);
            
            tree.setRoot(root);
            
        }
        
        Node<T1, T2> newNode = new Node<>();
        
        newNode.setKey(key);
        newNode.setValue(value);
        
        ArrayList<Node<T1, T2>> findableNode = (ArrayList<Node<T1, T2>>) root.getAllChildren();
        
        int k = 0;
        
        for(int i = 0; i < findableNode.size(); i++){
            
            if(findableNode.get(i).getKey().equals(newNode.getKey())){
                
                findableNode.get(i).addChildren(newNode);
                
            }else{
                
                k++;
                
            }
            
        }
        
        if(k == findableNode.size()){
            
            root.addChildren(newNode);
            
        }
    }

    @Override
    public void removeNodesFromTree(Tree<T1, T2> tree, T1 key) {
        
        Node<T1, T2> root = tree.getRoot();
        
        if(root == null){
            
            throw new NullPointerException("Дерево - пустое(не было создано)");
            
        }
        
        ArrayList<Node<T1, T2>> findableNode = (ArrayList<Node<T1, T2>>) root.getAllChildren();
        
        int k = 0;
        
        for(int i = 0; i < findableNode.size(); i++){
            
            if(findableNode.get(i).getKey().equals(key)){
                
                findableNode.remove(i);
                
            }else{
                
                k++;
                
            }
            
        }
        
        if(k == findableNode.size()){
            
            throw new NoSuchElementException("Нет такого элемента");
            
        }
        
    }

    @Override
    public String getNodeFromTree(Tree<T1, T2> tree, T1 key) {
        
        Node<T1, T2> root = tree.getRoot();
        
        if(root == null){
            
            throw new NullPointerException("Дерево - пустое(не было создано)");
            
        }
        
        ArrayList<Node<T1, T2>> findableNode = (ArrayList<Node<T1, T2>>) root.getAllChildren();
        
        
        int k = 0;
        
        String result = "";
        
        for(int i = 0; i < findableNode.size(); i++){
            
            if(findableNode.get(i).getKey().equals(key)){
                
                result = findableNode.get(i).toString();
                
            }else{
                
                k++;
                
            }
            
        }
        
        if(k == findableNode.size()){
            
            throw new NoSuchElementException("Нет такого узла");
            
        }
        
        return result;
        
    }
    
}
