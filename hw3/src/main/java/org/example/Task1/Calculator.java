package org.example.Task1;

public class Calculator {

    public static <T extends Number> Number sum(T firstNum, T secondNum) {
        if (firstNum instanceof Double || secondNum instanceof Double) {
            return firstNum.doubleValue() + secondNum.doubleValue();
        } else if (firstNum instanceof Float || secondNum instanceof Float) {
            return firstNum.floatValue() + secondNum.floatValue();
        } else if (firstNum instanceof Long || secondNum instanceof Long) {
            return firstNum.longValue() + secondNum.longValue();
        } else {
            return firstNum.intValue() + secondNum.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println("Calculator.sum(5,6) = " + Calculator.sum(5f, 6.1));
    }

}
