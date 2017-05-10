package karatsuba.functions;

import karatsuba.interfaces.UtilsInterface;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class UtilsImpl implements UtilsInterface{

    @Override
    public String trim(StringBuilder sb) {
        
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            
            sb.deleteCharAt(0);
            
        }
        
        return sb.toString();
        
    }

    @Override
    public String[] split(String s) {
       
        int m = s.length() >> 1;
        
        if((s.length() & 1) == 1){
            
            m += 1;
            
        }
        
        return new String[]{s.substring(0, m), s.substring(m)};
        
    }

    @Override
    public String pad(String num, int zeros) {
        
        StringBuilder sb = new StringBuilder(num);
        
        for(int i = 0; i < zeros; i++){
            
            sb.append(0);
            
        }
        
        return sb.toString();
    }
    
}
