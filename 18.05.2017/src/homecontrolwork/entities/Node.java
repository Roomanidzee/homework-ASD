package homecontrolwork.entities;

import homecontrolwork.interfaces.NodeInterface;
import java.util.Random;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class Node implements NodeInterface{
    
    private int key;//ключ узла
    private int priority;// приоритет узла
    
    private Node left;
    private Node right;
    
    private int size;
    
    public Node(int newKey, int newPriority){
        
        this.key = newKey;
        this.priority = newPriority;
        
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            
            return false;
            
        }
        
        if(!(obj instanceof Node)){
            
            return false;
            
        }
        
        Node other = (Node) obj;
        
        return (this.getKey() == other.getKey())
                && (this.getPriority() == other.getPriority());
    }

    @Override
    public int hashCode() {
        
        int hash = 3;
        
        hash = 41 * hash + this.getKey();
        hash = 41 * hash + this.getPriority();
        
        return hash;
        
    }
    
    @Override
    public String toString(){
        
        return "key = {" + this.getKey() + "}, priority = {" + this.getPriority() + "}";
        
    }
    
    public int getSize(){
        
        return this.size;
        
    }
    
    public void setSize(int newSize){
        
        this.size = newSize;
        
    }
    
    public int getKey(){
        
        return this.key;
        
    }
    
    public void setKey(int newKey){
        
        this.key = newKey;
        
    }
    
    public int getPriority(){
        
        return this.priority;
        
    }
    
    public void setPriority(int newPriority){
        
        this.priority = newPriority;
        
    }
    
    public Node getLeft(){
        
        return this.left;
        
    }
    
    public void setLeft(Node newLeft){
        
        this.left = newLeft;
        
    }
    
    public Node getRight(){
        
        return this.right;
        
    }
    
    public void setRight(Node newRight){
        
        this.right = newRight;
        
    }

    private void recalc(){
        
        this.setSize(this.getLeft().getSize() + this.getRight().getSize() + 1);
        
    }
    
    @Override
    public Node merge(Node left, Node right) {
        
        if(left == null){
            
            return right;
            
        }
        
        if(right == null){
            
            return left;
            
        }
        
        Node result = null;
        
        if(left.getPriority() > right.getPriority()){
            
            Node newRight = merge(left.getRight(), right);
            
            result = new Node(left.getKey(), left.getPriority());
            
            result.setLeft(left.getLeft());
            
            result.setRight(newRight);
            
        }else{
            
            Node newLeft = merge(left, right.getLeft());
            
            result = new Node(right.getKey(), right.getPriority());
            
            result.setLeft(newLeft);
            
            result.setRight(right.getRight());
            
        }
        
        result.recalc();
        
        return result;
    }

    @Override
    public void split(int key, Node left, Node right) {
        
        Node newNode = null;
        
        if(this.getKey() <= key){
            
            if(this.getRight() == null){
                
                right = null;
                
            }else{
                
                this.getRight().split(key, newNode, right);
                
            }
            
            left = new Node(this.getKey(), this.getPriority());
            
            left.setLeft(this.getLeft());
            
            left.setRight(newNode);
            
            left.recalc();
            
        }else{
            
            if(this.getLeft() == null){
                
                left = null;
                
            }else{
                
                this.getLeft().split(key, left, newNode);
                
            }
            
            right = new Node(this.getKey(), this.getPriority());
            
            right.setLeft(newNode);
            
            right.setRight(this.getRight());
            
            right.recalc();
            
        }
        
    }

    @Override
    public Node insert(Node node) {
        
        Random r = new Random();
        
        Node newLeft = null;
        Node newRight = null;
        
        split(node.getKey(), newLeft, newRight);
        
        Node middle = new Node(node.getKey(), r.nextInt(100));
        
        return merge(merge(newLeft, middle), newRight);
        
    }

    @Override
    public Node remove(Node node) {
        
        Node newLeft = null;
        Node newMiddle = null;
        Node newRight = null;
        
        split(node.getKey() - 1, newLeft, newRight);
        
        newRight.split(node.getKey(), newMiddle, newRight);
        
        return merge(newLeft, newRight);
        
    }

    @Override
    public Node get(int key) {
        
        Node current = this;
        
        while(current != null){
            
            int leftSize = current.getLeft().getSize();
            
            if(leftSize == key){
                
                return current;
                
            }
            
            if(leftSize < key){
                
                key -= leftSize + 1;
                
            }
            
            if(leftSize > key){
                
                current = current.getLeft();
                
            }else{
                
                current = current.getRight();
                
            }
            
        }
        
        return null;
        
    }
    
}
