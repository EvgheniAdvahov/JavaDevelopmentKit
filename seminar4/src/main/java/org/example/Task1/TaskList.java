package org.example.Task1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List
2. Отсортируйте коллекцию в алфавитном порядке
3. Отсортируйте коллекцию по кол-ву букв в слове
4. Разверните коллекцию
 */
public class TaskList {
    public static void main(String[] args) {
        List<String> listOfNames = createList();
        System.out.println(listOfNames);
        System.out.println(sortMyList(listOfNames));
        System.out.println(sortByCountLetters(listOfNames));
        System.out.println(reverseCollection(listOfNames));
    }

    public static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Volodia");
        list.add("Vasilii");
        list.add("Tom");
        list.add("Alex");
        list.add("Nadejda");

        return list;
    }

    public static List<String> sortMyList(List<String> list) {
        //1st variant
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
        //2nd variant
//        list.sort((o1, o2) -> o1.compareTo(o2));
        //3rd variant
//        list.sort(String::compareTo);

        //with streams
        return list.stream().sorted(Comparator.naturalOrder()).toList();
    }

    public static List<String> sortByCountLetters(List<String> list) {
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

//        list.sort((Comparator.comparingInt(String::length)));
//        list.sort(((o1, o2) -> o1.length() - o2.length()));
        return list.stream().sorted(((o1, o2) -> o1.length()- o2.length())).toList();
//        return list;
    }

    public static List<String> reverseCollection(List<String> list){
//        return list.reversed();
//
//        for (int i = 0; i < list.size()/2; i++) {
//            String temp = list.get(i);
//            list.set(i, list.get(list.size() - 1 -i));
//            list.set(list.size() - 1 -i, temp);
//        }
//        return list;

        Collections.reverse(list);
        return list;
    }


}
