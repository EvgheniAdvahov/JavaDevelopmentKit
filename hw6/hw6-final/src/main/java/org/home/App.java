package org.home;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * В качестве задачи реализовать код для демонстрации парадокса Монти Холла
 * и наглядно убедиться в верности парадокса
 * (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Подключить зависимость lombok.
 * Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 */
public class App {

    public static void main(String[] args) {
        Random rnd = new Random();
        int winDoor;
        int playerChoice;
        HashMap<Integer, Boolean> data = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            winDoor = rnd.nextInt(3);
            playerChoice = rnd.nextInt(3);
            removeOneDoor(winDoor,playerChoice);
            data.put(i,removeOneDoor(winDoor,playerChoice));
        }

        System.out.println(data);
        System.out.println(data.size());
        calculatePercentage(data);


    }

    public static boolean removeOneDoor(int winDoor, int playerChoice) {
        if (winDoor == playerChoice) {
            return false;
        } else {
            return true;
        }
    }

    public static void calculatePercentage(HashMap<Integer,Boolean> data){
        int winValue = 0;
        int size = data.size();
        for(Boolean value: data.values()) {
            if (value.equals(true)){
                System.out.println(value);
                winValue ++;
            }
        }
        System.out.println(winValue +" " +  size);
    }


}
