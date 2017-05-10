package karatsuba.functions;

import karatsuba.interfaces.CalcInterface;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class CalcImpl implements CalcInterface{
    
    private final UtilsImpl util = new UtilsImpl();
    
    private final String ZERO_STRING = "0";
    private final String ONE_STRING = "1";
    
    @Override
    public String multiply(String num1, String num2) {
        
        if(num1 == null || num2 == null){
            
            return null;
            
        }
        
        if(num1.equals("") || num2.equals("")){
            
            return "";
            
        }
        
        if(num1.length() == 1 || num2.length() == 1){
            
            return singleMultiply(num1, num2);
            
        }
        
        int len = Math.max(num1.length(), num2.length());
        
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        
        for(int i = sb1.length(); i < len; i++){
            
            sb1.insert(0, '0');
            
        }
        
        for(int i = sb2.length(); i < len; i++){
            
            sb2.insert(0, '0');
            
        }
        
        String[] first = this.util.split(num1);
        String[] second = this.util.split(num2);
        
        String a = first[0], b = first[1];
        String c = second[0], d = second[1];
        
        String AtoC = multiply(a, c);
        String BtoD = multiply(b, d);
        
        String ABtoCD = multiply(add(a, b), add(c, d));
        
        String e = subtract(subtract(ABtoCD, BtoD), AtoC);
        
        return add(add(this.util.pad(AtoC, (len >> 1) << 1), this.util.pad(e, len >> 1)), BtoD);
    }

    @Override
    public String singleMultiply(String num1, String num2) {
        
        if(num1.equals(this.ZERO_STRING) || num2.equals(this.ZERO_STRING)){
            
            return this.ZERO_STRING;
            
        }
        
        if(num1.equals(this.ONE_STRING)){
            
            return num1;
            
        }
        
        if(num2.equals(this.ONE_STRING)){
            
            return num2;
            
        }
        
        String a = null, b = null;
        
        if(num1.length() == 1){
            
            a = num2;
            b = num1;
            
        }else{
            
            a = num1;
            b = num2;
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        int c = 0, s = b.charAt(0) - '0';
        int f = 0;
        
        for(int i = a.length() - 1; i >= 0; i--){
            
            f = a.charAt(i) - '0';
            
            sb.insert(0, ((f * s) + c) % 10);
            
            c = ((f * s) + c) / 10;
            
        }
        
        if(c > 0){
            
            sb.insert(0, c);
            
        }
        
        return this.util.trim(sb);
    }

    @Override
    public String add(String num1, String num2) {
        
        String a = null;
        String b = null;
        
        if(num1.length() >= num2.length()){
            
            a = num1;
            b = num2;
            
        }
        
        if(num1.length() < num2.length()){
            
            a = num2;
            b = num1;
            
        }
        
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int diff = a.length() - b.length();
        
        int f = 0, s = 0, p = 0;
        
        for(int i = a.length() - 1; i >= 0; i--){
            
            f = a.charAt(i) - '0';
            
            if(i - diff < 0){
                
                s = 0;
                
            }else{
                
                s = b.charAt(i - diff) - '0';
                
            }
            
            p = f + c + s;
            
            sb.insert(0, p % 10);
            
            c = p / 10;
            
        }
        
        if(c > 0){
            
            sb.insert(0, c);
            
        }
        
        return this.util.trim(sb);
    }

    @Override
    public String subtract(String num1, String num2) {
        
        String a = null;
        String b = null;
        
        if(num1.length() > num2.length()){
            
            a = num1;
            b = num2;
            
        }
        
        if(num1.length() < num2.length()){
            
            a = num2;
            b = num1;
            
        }
        
        if(num1.length() == num2.length()){
            
            int k = 0;
            
            while(k != num1.length() && k != num2.length()){
                
                if(num1.charAt(k) - '0' > num2.charAt(k) - '0'){
                    
                    a = num1;
                    b = num2;
                    break;
                    
                }
                
                if(num2.charAt(k) - '0' > num1.charAt(k) - '0'){
                    
                    a = num2;
                    b = num1;
                    break;
                    
                }
                
                k++;
            }
            
            if(k == num1.length() && k == num2.length()){
                
                return this.ZERO_STRING;
                
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        int c = 0; 
        int diff = a.length() - b.length();
        
        int f = 0, s = 0, p = 0;
        
        for(int i = a.length() - 1; i > 0; i--){
            
            f = a.charAt(i) - '0';
            
            if(i - diff < 0){
                
                s = 0;
                
            }else{
                
                s = b.charAt(i - diff) - '0';
                
            }
            
            p = f - c - s;
            
            if(p < 0){
                
                p += 10;
                c = 1;
                
            }else{
                
                c = 0;
                
            }
            
            sb.insert(0, p);
            
        }
        
        return this.util.trim(sb);
    }
    
}
