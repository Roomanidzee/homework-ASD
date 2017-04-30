package launch;

import processing.BinaryNumber;
//import processing.CalculationsImpl;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class BinaryNumberViewer {
    //чтобы проверить работу вычислений, раскомментируйте строки
    public static void main(String[] args){
        
        BinaryNumber number1 = new BinaryNumber(142);
        BinaryNumber number2 = new BinaryNumber(56);
        
        //CalculationsImpl calc = new CalculationsImpl();
        
        System.out.println(number1.toString());
        System.out.println(number2.toString());
        
//        BinaryNumber result = calc.addTo(number1, number2);
//        
//        System.out.println(result.toString());
        
    }
    
}
