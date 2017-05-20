package homecontrolwork.entities;

import homecontrolwork.interfaces.TreapInterface;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class Treap implements TreapInterface{
    
    private Node root;
    
    public Node getRoot(){
        
        return this.root;
        
    }
    
    public void setRoot(Node newRoot){
        
        this.root = newRoot;
        
    }

    @Override
    public boolean equals(Object obj) {
     
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof Treap)) {
            
            return false;
            
        }
        Treap other = (Treap) obj;
        
        return this.getRoot().equals(other.getRoot());
    }

    @Override
    public int hashCode() {
        
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.getRoot());
        
        return hash;
    }
    
    @Override
    public String toString(){
        
        return "key = {" + this.getRoot().getKey() + ", priority = {" 
                + this.getRoot().getPriority() + "}, left = {"
                + this.getRoot().getLeft().toString() + "}, right = {"
                + this.getRoot().getRight().toString() + "}.";
        
    }

    @Override
    public Node merge(Node left, Node right) {
        
        if(left == null || right == null){
            
            return null;
            
        }
        
        if(this.getRoot() == null){
            
            return null;
            
        }
        
        return this.getRoot().merge(left, right);
        
    }

    @Override
    public void split(int key) {
        
        if(this.getRoot() == null){
            
            throw new NullPointerException("У дерева нет корневого узла");
            
        }
        
        this.root.split(key, this.getRoot().getLeft(), this.getRoot().getRight());
        
    }

    @Override
    public Node insert(int key) {
        
        Random r = new Random();
        
        if(this.getRoot() == null){
            
            this.root.setKey(key);
            this.root.setPriority(r.nextInt(100));
            return this.root;
            
        }
        
        Node newNode = new Node(key, this.getRoot().get(this.root.getSize()).getPriority());
        
        return this.root.insert(newNode);
        
    }

    @Override
    public Node remove(int key) {
        
        if(this.getRoot() == null){
            
            throw new NullPointerException("У дерева нет корневого узла");
            
        }
        
        if(this.getRoot().get(key) == null){
            
            throw new NullPointerException("В дереве нет такого узла");
            
        }
        
        return this.root.remove(this.getRoot().get(key));
        
    }

    @Override
    public int getTreapSize() {
        
        if(this.getRoot() != null){
            
            return this.getRoot().getSize();
            
        }else{
            
            return 0;
            
        }
        
    }

    @Override
    public Node get(int key) {
        
        if(this.getRoot() == null){
            
            return null;
            
        }
        
        return this.getRoot().get(key);
        
    }
    
}
