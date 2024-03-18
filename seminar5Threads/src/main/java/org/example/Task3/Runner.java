package org.example.Task3;

import java.util.concurrent.CountDownLatch;

public class Runner extends Thread {

    private String name;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    public void goToStart() throws InterruptedException {
        System.out.println(this.name + " Go to start");
        Thread.sleep((long) (Math.random() * 3000));
        System.out.println(this.name + " Ready for start");
        cdl.countDown();
    }

    public void goToFinish() throws InterruptedException {
        System.out.println(this.name + " start go to finish");
        Thread.sleep((long) (Math.random() * 3000));
        System.out.println(this.name + " finished");
    }

    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();
            goToFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
