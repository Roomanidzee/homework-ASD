package binarysearchtree.entities;

import binarysearchtree.exceptions.DuplicateKeyException;
import binarysearchtree.interfaces.NodeInterface;
import java.util.Objects;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 * @param <T> value
 */
public class Node<T> implements NodeInterface<T>{

    private int key;
    private T value;
    
    private Node<T> left;
    private Node<T> right;
    
    public Node(int key, T value){
        
        if(value == null){
            
            throw new IllegalArgumentException("Узел не может иметь "
                    + "значение null");
            
        }
        
        this.key = key;
        this.value = value;
        
    }
    
    public int getKey(){
        
        return this.key;
        
    }
    
    public void setKey(int newKey){
        
        this.key = newKey;
        
    }
    
    public T getValue(){
        
        return this.value;
        
    }
    
    public void setValue(T newValue){
        
        this.value = newValue;
        
    }
    
    public Node<T> getLeft(){
        
        return this.left;
        
    }
    
    public void setLeft(Node<T> newLeft){
        
        if(this.equals(newLeft)){
            
            throw new IllegalArgumentException("Не моэет добавить сам себе к "
                    + "себе же как левый дочерний узел");
            
        }
        
        this.left = newLeft;
        
    }
    
    public Node<T> getRight(){
        
        return this.right;
        
    }
    
    public void setRight(Node<T> newRight){
        
        if(this.equals(newRight)){
            
            throw new IllegalArgumentException("Не моэет добавить сам себе к "
                    + "себе же как правый дочерний узел");
            
        }
        
        this.right = newRight;
        
    }
    
    @Override
    public int hashCode() {
        
        int hash = 5;
        
        hash = 67 * hash + this.key;
        hash = 67 * hash + Objects.hashCode(this.value);
        
        return hash;
        
    }
    

    @Override
    public boolean equals(Object obj) {      
        
        if (obj == null) {
            
            return false;
            
        }
        
        if(!(obj instanceof Node)){
            
            return false;
            
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        
        Node<T> other = (Node<T>) obj;
        
        if (this.getKey() != other.getKey()) {
            return false;
        }
        
        return Objects.equals(this.getValue(), other.getValue());
    }

    
    
    @Override
    public String toString(){
        
        return "key = {" + this.getKey() + "}, value = {" + this.getValue() + "}";
        
    }
    
    @Override
    public Node<T> findByKey(int key, Node<T> node) {
        
        if(node == null){
            
            return null;
            
        }
        
        if(node.getKey() == key){
            
            return node;
            
        }else if(node.getKey() > key){
            
            return findByKey(key, node.getLeft());
            
        }else{
            
            return findByKey(key, node.getRight());
            
        }
        
    }

    @Override
    public Node<T> findMin(Node<T> node) {
        
        if(node == null){
            
            return null;
            
        }
        
        if(node.getLeft() != null){
            
            return findMin(node.getLeft());
            
        }else{
            
            return node;
            
        }
        
    }

    @Override
    public Node<T> findMax(Node<T> node) {
        
        if(node == null){
            
            return null;
            
        }
        
        if(node.getRight() != null){
            
            return findMax(node.getRight());
            
        }else{
            
            return node;
            
        }
        
    }

    @Override
    public Node<T> addNode(Node<T> node, Node<T> newNode) {
        
        if(node == null || newNode == null){
            
            return null;
            
        }
        
        if(newNode.getKey() < node.getKey()){
            
            if(node.getLeft() == null){
                
                node.setLeft(newNode);
                
                return node;
                
            }else{
                
                return addNode(node.getLeft(), newNode);
                
            }
            
        }else if(newNode.getKey() > node.getKey()){
            
            if(node.getRight() == null){
                
                node.setRight(newNode);
                
                return node;
                
            }else{
                
                return addNode(node.getRight(), newNode);
                
            }
            
        }else{            
            
            try {
                
                throw new DuplicateKeyException("У узлов одинаковые ключи");
                
            } catch (DuplicateKeyException ex) {
                
                System.err.println(ex.getMessage());
                        
            }  
                
            return null;           
            
        }
        
    }

    @Override
    public Node<T> removeNode(Node<T> node, Node<T> newNode) {
        
        Node<T> resultNode = null;
        
        if(node == null || newNode == null){
            
            return null;
            
        }
        
        if(newNode.getKey() < node.getKey()){
            
            node.setLeft(removeNode(node.getLeft(), newNode));
            
        }else if(newNode.getKey() > node.getKey()){
            
            node.setRight(removeNode(node.getRight(), newNode));
            
        }else if(node.getLeft() != null && node.getRight() != null){
            
            int newKey = findMin(node.getRight()).getKey();
            T newValue = findMin(node.getRight()).getValue();
            
            Node<T> freshNode = new Node<>(newKey, newValue);
            
            node.setRight(removeNode(node.getRight(), freshNode));
            
        }else{
            
           if(node.getLeft() != null){
               
               resultNode = new Node<>(node.getLeft().getKey(), node.getLeft().getValue());
               
               node = resultNode;
               
           }else{
               
               resultNode = new Node<>(node.getRight().getKey(), node.getRight().getValue());
               
               node = resultNode;
               
           }
            
        }
        
        return node;
        
    }
    
}
