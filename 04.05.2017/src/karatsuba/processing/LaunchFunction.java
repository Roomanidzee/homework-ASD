package karatsuba.processing;

import java.util.Scanner;
import karatsuba.functions.CalcImpl;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class LaunchFunction {
    
    public static void launch(){
        
        CalcImpl calc = new CalcImpl();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Введите два числа: ");
        
        String first = sc.nextLine();
        String second = sc.nextLine();
        
        System.out.println("Результат: " + calc.multiply(first, second));
        
    }
    
}
