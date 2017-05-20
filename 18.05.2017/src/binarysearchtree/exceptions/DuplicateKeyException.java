package binarysearchtree.exceptions;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class DuplicateKeyException extends Exception{
    
    private static final long serialVersionUID = 6875562785629734856L;
    
    public DuplicateKeyException(){}
    
    public DuplicateKeyException(String msg){
        
        super(msg);
        
    }
    
}
