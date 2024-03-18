package org.example.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadForTest implements Runnable {

    String message;
    Integer value = 0;
    private CountDownLatch cdl;

    public ThreadForTest(String message, CountDownLatch cdl) {
        this.message = message;
        this.cdl = cdl;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> listOfThreads = new ArrayList<>();
        CountDownLatch cdl = new CountDownLatch(3);

        ThreadForTest threadForTest1 = new ThreadForTest("1", cdl);
        ThreadForTest threadForTest2 = new ThreadForTest("2", cdl);
        ThreadForTest threadForTest3 = new ThreadForTest("3", cdl);

        listOfThreads.add(new Thread(threadForTest1));
        listOfThreads.add(new Thread(threadForTest2));
        listOfThreads.add(new Thread(threadForTest3));

            for (Thread thread : listOfThreads) {
                thread.start();
            }
            cdl.await();

        System.out.println("All threads completed.");


    }

    public void inc() {
        value++;
    }


    @Override
    public void run() {
        try {
            inc();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "value" + value + " message: " + message);
            cdl.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
