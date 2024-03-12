package org.example.Task2;

public class CompareArray<T> {


    public static <T> boolean comareArrays(T[] firstArray, T[] secondArray){
        if (firstArray.length != secondArray.length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {5,6,7,8};

//        CompareArray.comareArrays(a, b);
    }

}
