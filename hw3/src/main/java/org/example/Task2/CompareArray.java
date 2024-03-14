package org.example.Task2;

public class CompareArray<T> {
/*
Напишите обобщенный метод compareArrays(), который принимает два массива
 и возвращает true, если они одинаковые, и false в противном случае.
  Массивы могут быть любого типа данных, но должны иметь одинаковую длину и
  содержать элементы одного типа по парно по индексам.
 */

    public static <T> boolean compareArrays(T[] firstArray, T[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        int i = 0;
        while (i < firstArray.length) {
            if (firstArray[i].getClass() != secondArray[i].getClass()) {
                System.out.println("Разные");
                return false;
            }
            i++;
        }
        System.out.println("Одинаковые");
        return true;
    }

    public static void main(String[] args) {
        Number[] firstArray = {1, 2, 3, 4};
        String[] secondArray = {"1", "2", "3", "4"};
        Object[] thirdArray = {"1", "2", "3", "4"};

        CompareArray.compareArrays(firstArray, secondArray);
        CompareArray.compareArrays(secondArray, thirdArray);
    }

}
