package binarynumber.interfaces;

import binarynumber.processing.BinaryNumber;

/**
 *
 * @author Андрей Романов <steampart@gmail.com>
 */
public interface CalculationsInterface {
    //основные операции для работы с числами
    BinaryNumber addTo(BinaryNumber first, BinaryNumber second);
    BinaryNumber multiplyTo(BinaryNumber first, BinaryNumber second);
    BinaryNumber subtractTo(BinaryNumber first, BinaryNumber second);
    
}
