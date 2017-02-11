package StackAndQueueExamples.processing;

import StackAndQueue.processing.QueueRealizer;
import StackAndQueue.processing.StackRealizer;

/**
 *
 * @author Андрей Романов
 */
public class InitFunction {
    
    public static void init(){
        
        CalculateFunctionsRealizer calc = new CalculateFunctionsRealizer();
        StackRealizer sr = new StackRealizer();
        QueueRealizer qr = new QueueRealizer();
        
        float h = 1.6f;
        int i = 1;
        int k = 1;
        float result = 0.0f;
        
        for(float a = 0.7f; a < 2.8; a+=0.7){
            
            result = calc.triangleSquare(a, h);
            System.out.println("Triangle, result " + i + ": " + result );
            sr.add(result);
            i++;
            
        }
        
        System.out.println();
        
        for(float r = 0.7f; r < 2.8; r+=0.7){
            
            result = calc.sphereSize(r);
            System.out.println("Sphere, result " + k + ": " + result );
            qr.add(result);
            k++;
            
        }
        
        System.out.println();
        
        System.out.println("Pop triangle result: " + sr.pop());
        System.out.println("Peek triangle result: " + sr.peek());
        
        System.out.println();
        
        System.out.println("Pop sphere result: " + qr.pop());
        System.out.println("Peek sphere result: " + qr.peek());
        
        
        
        
    }
    
}
