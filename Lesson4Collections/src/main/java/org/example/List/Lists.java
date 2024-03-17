package org.example.List;

import java.util.ArrayList;
import java.util.Arrays;

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
        // [] <-1
        // [_], <-2
        // [1], [__], [1 _], [1,2] <-3
        // [1 2], [____], [1,2,__], [1,2,3_] <- O(1)
        // [1 2 3 _], [1,2,3,4]

        // [1 2 3 4 5] <-7,2 O(n)
        // [__________]
        // [1 2 3 4 5 _ _ _ _ _]
        // [1 2 3 3 4 5 _ _ _ _]
        // [1 2 7 3 4 5 _ _ _ _]
//        list.get(1) O(1)
//        list.set(1, 2) O(1)
//        list.contains() O(n) <- Не особо подходит для поиска

    }

}
