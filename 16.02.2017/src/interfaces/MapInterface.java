package interfaces;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public interface MapInterface {
    
    void add(String key, Object value);
    Object remove(String key);
    Object get(String key);
    void set(String key, Object value);
    void removeAll();
    String[] getKeys();
    Object[] getValues();
    int size();
    
}
