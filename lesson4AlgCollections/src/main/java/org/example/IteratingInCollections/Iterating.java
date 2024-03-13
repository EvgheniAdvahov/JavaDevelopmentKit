package org.example.IteratingInCollections;

import java.util.Collection;
import java.util.Iterator;

public class Iterating {
    public static void main(String[] args) {
        Collection<Integer> collection = java.util.List.of(1,2,3,4,5);
        // 1 Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // For each
        for (Integer value : collection) {
            System.out.print(value + " ");
        }
        System.out.println();

        //Stream api
        collection.stream().forEach(value -> System.out.print(value + " "));
        System.out.println();
        // second varian Strem api(method reference)
        collection.stream().forEach(System.out::println);


    }
}
