package launcher;

import sorting_functions.SelectionSort;
import sorting_functions.InsertionSort;
import java.util.Random;
import java.util.Arrays;
import sorting_functions.CountingSort;
import sorting_functions.MergeSort;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public class SortingViewer {
    
    public static void main(String[] args){
        
        Random r = new Random();
        int[] array = new int[10];
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];
        int[] array4 = new int[10];
        
        for(int i = 0; i < array.length; i++){
            
            array[i] = r.nextInt(20);
            
        }
        
        System.arraycopy(array, 0, array1, 0, array.length);
        System.arraycopy(array, 0, array2, 0, array.length);
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array, 0, array4, 0, array.length);
        
        System.out.println("Сортировка выборкой");
        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        SelectionSort.sort(array);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
        
        System.out.println();
        
        System.out.println("Сортировка вставками");
        System.out.println();
        System.out.println("Со сложностью O(n*n) :");
        System.out.println("Исходный массив: " + Arrays.toString(array1));
        
        long start1 = System.nanoTime();
        
        InsertionSort.sort1(array1);
        
        long finish1 = System.nanoTime();
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array1));
        System.out.println("Время работы : " + (finish1 - start1) + " наносекунд");
        System.out.println();
        
        System.out.println("Со сложностью O(n * log n) : ");
        System.out.println("Исходный массив: " + Arrays.toString(array2));
        
        long start2 = System.nanoTime();
        
        InsertionSort.sort2(array2);
        
        long finish2 = System.nanoTime();
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array2));
        System.out.println("Время работы : " + (finish2 - start2) + " наносекунд");
        
        System.out.println();
        
        System.out.println("Сортировка слиянием");
        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(array3));
        
        MergeSort.sort(array3);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array3));
        
        System.out.println();
        
        System.out.println("Сортировка подсчетом");
        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(array4));
        
        CountingSort.sort(array4);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array4));
        
        System.out.println();        
    }
    
}
