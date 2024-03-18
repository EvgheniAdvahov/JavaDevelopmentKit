package org.example.Task3;

import java.util.concurrent.CountDownLatch;

/*
В рамках выполнения задачи необходимо:
    3 бегуна должны прийти к старту гонки
    Программа должна гарантировать, что гонка начнется только когда все
    три участника будут на старте
    Программа должна отсчитать “На старт”, “Внимание”, “Марш”
    Программа должна завершиться когда все участники закончат гонку.
 */
public class MainTask3 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);

        Runner runner1 = new Runner("Vasilii",cdl);
        Runner runner2 = new Runner("Victor",cdl);
        Runner runner3 = new Runner("Ivan",cdl);

        runner1.start();
        runner2.start();
        runner3.start();


        while (cdl.getCount() != 1){
            Thread.sleep(100);
        }
        System.out.println("Ready");
        Thread.sleep(1000);
        System.out.println("Set");
        Thread.sleep(1000);
        System.out.println("Go");
        cdl.countDown();

    }

}
