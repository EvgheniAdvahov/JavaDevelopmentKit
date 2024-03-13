package org.example.List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Используется для хранения упорядоченной последовательности обьектов -
он содержит основанные на индексах методы для вставки, обновления, удаления и
поиска элементов. Он также может иметь повтояющиеся элемены и null в качестве значения.
 */
public class Lists {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));

//        ArrayList<Integer> list = new ArrayList<>(){
//            {
//                add(1);
//                add(2);
//                add(3);
//                add(4);
//                add(5);
//            }
//        };


        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        System.out.println(list);


    }
}
