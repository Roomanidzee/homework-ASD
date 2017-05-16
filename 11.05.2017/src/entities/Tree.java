package entities;

import java.util.Objects;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T1> key
 * @param <T2> value
 */
public class Tree<T1, T2> {
    
    private Node<T1, T2> root;

    @Override
    public int hashCode() {
        
        int hash = 7;
        
        hash = 59 * hash + Objects.hashCode(this.root);
        
        return hash;
        
    }
    
    @Override
    public boolean equals(Object obj){
        
       if(obj == null){
           
           return false;
           
       } 
       
       if(!(obj instanceof Tree)){
           
           return false;
           
       }
       
       Tree<T1, T2> comparableTree = (Tree<T1, T2>) obj;
       
       if(this.getRoot().getChildrenCount() != 
               comparableTree.getRoot().getChildrenCount())
       {
           
           return false;
           
       }
       
       boolean result = true;
       
       for(int i = 0; i < comparableTree.getRoot().getChildrenCount() - 2; i++){
           
           result = result && this.getRoot()
                                  .getChildren(i)
                                  .equals(comparableTree
                                          .getRoot()
                                          .getChildren(i));
           
       }
       
       return result;
       
    }
    
    @Override
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < root.getChildrenCount(); i++){
            
            sb.append(root.getChildren(i).toString());
            sb.append("\\n");
            
        }
        
        return sb.toString();
        
    }
    
    public void setRoot(Node<T1, T2> newRoot){
        
        this.root = newRoot;
        
    }
    
    public Node<T1, T2> getRoot(){
        
        return root;
        
    }
    
}
