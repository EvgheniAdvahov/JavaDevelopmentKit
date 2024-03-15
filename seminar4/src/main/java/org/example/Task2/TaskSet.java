package org.example.Task2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
Получите уникальный список Set на основании List
Определить наименьший элемент(алфавитный порядок)
Определите наибольший элемент ( по кол-ву букв в слове но в обратном порядке)
Удалите все элементы содержащие букву А
 */
public class TaskSet {
    public static void main(String[] args) {
        List<String> listOfNames = createList();
        HashSet<String> setOfName = new HashSet<>(listOfNames);
        System.out.println(setOfName);
        System.out.println(minElementAlphabet(setOfName));
        System.out.println(maxCountElementInReversed(setOfName));
        System.out.println(deleteByCharacter(setOfName));
        System.out.println(deleteByCharacterWithStream('j', setOfName));

    }
    public static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Volodia");
        list.add("Tom");
        list.add("Tom");
        list.add("Alex");
        list.add("Nadejda");

        return list;
    }

    public static String minElementAlphabet(HashSet<String> set){
        return set.stream().min(((o1, o2) -> o1.compareTo(o2))).orElse(null);

    }

    public static String maxCountElementInReversed(HashSet<String> set) {
        return set.stream().max((o1, o2) -> o1.length()- o2.length()).orElse(null);
    }

    public static HashSet<String> deleteByCharacter(HashSet<String> set) {
        HashSet<String> newSet = new HashSet<>();
        for (String element : set) {
            if (!element.contains("a")){
                newSet.add(element);
            }
        }
        return newSet;
    }
    public static HashSet<String> deleteByCharacterWithStream(char deleteSymbol, HashSet<String> set){
        set.removeIf(x -> x.contains(String.valueOf(deleteSymbol)));
        return set;
    }

}
