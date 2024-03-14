package org.example.Task1;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
 над которыми должна быть произведена операция. Методы должны возвращать результат своей
 работы.
 */

public class Calculator {

    public static <T extends Number> Number sum(T firstNum, T secondNum) {
        return firstNum.doubleValue() + secondNum.doubleValue();
    }


    public static <T extends Number> Number multiply(T firstNum, T secondNum) {
        return firstNum.doubleValue() * secondNum.doubleValue();

    }

    public static <T extends Number> Number devide(T firstNum, T secondNum) {
        return firstNum.doubleValue() / secondNum.doubleValue();

    }

    public static <T extends Number> Number substract(T firstNum, T secondNum) {
        return firstNum.doubleValue() - secondNum.doubleValue();

    }

    public static void main(String[] args) {
        System.out.println("Calculator.sum(5f,6.1) = " + Calculator.sum(5f, 6.1));
        System.out.println("Calculator.multiply(0.5, 2f) = " + Calculator.multiply(0.5, 2f));
        System.out.println("Calculator.devide(5l, 2f) = " + Calculator.devide(5l, 2f));
        System.out.println("Calculator.substract(5, 3.14f) = " + Calculator.substract(5, 3.14f));
    }

}
