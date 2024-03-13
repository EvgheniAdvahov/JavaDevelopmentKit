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


    public static <T extends Number> Number multiply(T firstNum, T secondNum) {
        if (firstNum instanceof Double || secondNum instanceof Double) {
            return firstNum.doubleValue() * secondNum.doubleValue();
        } else if (firstNum instanceof Float || secondNum instanceof Float) {
            return firstNum.floatValue() * secondNum.floatValue();
        } else if (firstNum instanceof Long || secondNum instanceof Long) {
            return firstNum.longValue() * secondNum.longValue();
        } else {
            return firstNum.intValue() * secondNum.intValue();
        }
    }

    public static <T extends Number> Number devide(T firstNum, T secondNum) {
        if (firstNum instanceof Double || secondNum instanceof Double) {
            return firstNum.doubleValue() / secondNum.doubleValue();
        } else if (firstNum instanceof Float || secondNum instanceof Float) {
            return firstNum.floatValue() / secondNum.floatValue();
        } else if (firstNum instanceof Long || secondNum instanceof Long) {
            return firstNum.longValue() / secondNum.longValue();
        } else {
            return firstNum.intValue() / secondNum.intValue();
        }
    }

    public static <T extends Number> Number substract(T firstNum, T secondNum) {
        if (firstNum instanceof Double || secondNum instanceof Double) {
            return firstNum.doubleValue() - secondNum.doubleValue();
        } else if (firstNum instanceof Float || secondNum instanceof Float) {
            return firstNum.floatValue() - secondNum.floatValue();
        } else if (firstNum instanceof Long || secondNum instanceof Long) {
            return firstNum.longValue() - secondNum.longValue();
        } else {
            return firstNum.intValue() - secondNum.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println("Calculator.sum(5f,6.1) = " + Calculator.sum(5f, 6.1));
        System.out.println("Calculator.multiply(0.5, 2f) = " + Calculator.multiply(0.5, 2f));
        System.out.println("Calculator.devide(5l, 2f) = " + Calculator.devide(5l, 2f));
        System.out.println("Calculator.substract(5, 3.14f) = " + Calculator.substract(5, 3.14f));
    }

}
