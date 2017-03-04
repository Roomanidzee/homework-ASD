package launcher;

import entries.Entry;
import lists.LinkedList;
import lists.DoublyLinkedList;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class ListViewer {
    
    public static void main(String[] args){
        
        Entry<String> p = new Entry<>();
        
        LinkedList<String> stringLink = new LinkedList<>();
        DoublyLinkedList<String> doublyStringLink = new DoublyLinkedList<>();
        
        
        stringLink.addAfter(p, "test1");
        stringLink.add("test");
        
        //System.out.println(stringLink.get(0));
        //System.out.println(stringLink.size());
        
        doublyStringLink.addAfter(p, "test1");
        doublyStringLink.add("test");
        
        //System.out.println(doublyStringLink.get(0));
        //System.out.println(doublyStringLink.size());
        
    }
    
}
