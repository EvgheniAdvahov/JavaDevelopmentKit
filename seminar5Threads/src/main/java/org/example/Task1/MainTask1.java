package org.example.Task1;

/*
В рамках выполнения задачи необходимо:
    Создать два класс ObjectA, ObjectB
    Реализовать класс в котором два потока при запуске
    провоцируют DeadLock для объектов ObjectA, ObjectB
 */
public class MainTask1 {

    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Thread thread1 = new Thread(() ->{
           synchronized (objectA){
               System.out.println("Поток 1 заблокировал поток A");
               synchronized (objectB){
                   System.out.println("Поток 2 заблокировал поток B");
               }
           }
        });
        Thread thread2 = new Thread(() ->{
            synchronized (objectB){
                System.out.println("Поток 2 заблокировал поток B");
                synchronized (objectA){
                    System.out.println("Поток 1 заблокировал поток A");
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
