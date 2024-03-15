package org.example.Task3;


import java.util.HashMap;
import java.util.Map;

/*
Создайте телефонный справочник с помощью Map - телефон ключ, имя - значение
Найти человека с самым маленьким номером телефона
Найдите номер телефона человека чьё имя самое большое в алфавитном порядке
 */
public class TaskMap {
    public static void main(String[] args) {
        Map<String, String> map = createMap();
        System.out.println(map);
        System.out.println(findSmallestTelNumber(map));
        System.out.println(findNumberByName(map));
        System.out.println(findNumberByName2(map));

    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "Name1");
        map.put("234", "Name2");
        map.put("345", "Name3");
        map.put("567", "Name4");
        map.put("678", "Zame55");
        map.put("789", "Ame6");

        return map;
    }

    public static String findSmallestTelNumber(Map<String, String> map) {
        return map.keySet().stream().min(((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2)))
                .orElse(null);
    }

    public static String findNumberByName(Map<String, String> map) {
        String temp = "A";
        String key = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (temp.compareTo(entry.getValue()) < 0) {
                temp = entry.getValue();
                key = entry.getKey();
            }
        }
        return temp + ": "+ key;
    }

    public static String findNumberByName2(Map<String, String> map){
        return map.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get().getKey();
    }
}
