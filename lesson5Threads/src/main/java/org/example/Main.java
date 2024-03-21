package org.example;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
////        System.out.println("Hello world!");
////        System.out.println(Thread.currentThread().getName());
//        for (int i = 0; i < 3; i++) {
//            MyThread thread = new MyThread();
//            thread.start();
//            thread.join();
////            new MyThread().start();
//        }
//        System.out.println("=================");
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new MyRunnable());
//            thread.start();
//            thread.join();
////            new Thread(new MyRunnable()).start();
//        }
////
////        for (int i = 0; i < 3; i++) {
////            new Thread(() ->{
////                System.out.println("LAMBDA::Hello from " + Thread.currentThread());
////            }).start();
////        }
//
        Thread tic = new Thread(new TicTak("["));
        Thread tac = new Thread(new TicTak("]"));
//        tic.setDaemon(true);
//        tac.setDaemon(true);
        tic.start();
        tac.start();
//        //иногда не отображается

//        long start = System.currentTimeMillis();
//        Task task = new Task(0);
//        CountDownLatch cdl = new CountDownLatch(3);
//        task.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//        }
//        cdl.await();
//        System.out.println(task.getValue());
//        long end = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start) + "ms.");
    }
}