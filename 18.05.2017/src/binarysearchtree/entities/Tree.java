package binarysearchtree.entities;

import binarysearchtree.interfaces.TreeInterface;
import java.util.Objects;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T> value
 */
public class Tree<T> implements TreeInterface<T>{
    
    private Node<T> root;
    
    public Node<T> getRoot(){
        
        return this.root;
        
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            
            return false;
            
        }
        if (!(obj instanceof Tree)) {
            
            return false;
            
        }
        
        Tree<T> other = (Tree<T>) obj;
        
        return this.getRoot().equals(other.getRoot());
    }
    
    @Override
    public String toString(){
        
        return "key = {" + this.getRoot().getKey() + "}, value = {" + this.getRoot().getValue() + "},"
                + "left child = {" + this.getRoot().getLeft().toString() + "}, "
                + "right child = {" + this.getRoot().getRight().toString() + "}";
        
    }
    
    @Override
    public int hashCode(){
        
        int hash = 7;
        
        hash = 37 * hash + Objects.hashCode(this.root);
        
        return hash;
        
    }
    
    public void setRoot(Node<T> newRoot){
        
        this.root = newRoot;
        
    }
    
    @Override
    public Node<T> findByKey(int key) {
        
        if(this.getRoot() == null){
            
            return null;
            
        }
        
        return this.root.findByKey(key, this.getRoot());
        
    }

    @Override
    public Node<T> findMin() {
        
        if(this.getRoot() == null){
            
            return null;
            
        }
        
        return this.root.findMin(this.getRoot());
        
    }

    @Override
    public Node<T> add(int key, T value) {
        
        Node<T> newNode = new Node<>(key, value);
        
        if(this.getRoot() == null){
            
            this.setRoot(newNode);
            
            return this.getRoot();
            
        }else{
            
            return this.root.addNode(this.getRoot(), newNode);
            
        }
        
    }

    @Override
    public Node<T> remove(int key, T value) {
        
        Node<T> newNode = new Node<>(key, value);
        
        if(this.getRoot() == null){
            
            this.setRoot(newNode);
            
            return this.getRoot();
            
        }else{
            
            return this.root.removeNode(this.getRoot(), newNode);
            
        }
        
    }
    
}
