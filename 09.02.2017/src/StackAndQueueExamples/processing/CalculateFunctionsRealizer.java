package StackAndQueueExamples.processing;

import StackAndQueueExamples.interfaces.CalculateFunctions;

/**
 *
 * @author Андрей Романов
 */
public class CalculateFunctionsRealizer implements CalculateFunctions{
    
    @Override
    public float triangleSquare(float a, float h){
        
        float result = (float) ((0.5 * a)/h);
        
        return (float) (Math.rint(10 * result)/10);
        
    }
    
    @Override
    public float sphereSize(float r){
        
        float result = (float) ((4/3) * Math.PI * r * r * r);
        
        return (float) (Math.rint(10 * result)/10);
        
    }
    
}
