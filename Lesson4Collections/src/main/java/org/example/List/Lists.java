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
    }

}
