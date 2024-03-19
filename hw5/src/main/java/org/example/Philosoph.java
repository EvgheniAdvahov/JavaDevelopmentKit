package org.example;

import java.util.concurrent.CountDownLatch;

public class Philosoph extends Thread {

    CountDownLatch cdl = new CountDownLatch(55);

    Fork leftFork;
    Fork rightFork;

    private String name;

    public Philosoph(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() throws InterruptedException {
        synchronized (leftFork) {
            synchronized (rightFork) {
                System.out.println("Думает " + name + ": при этом вернул вилки: " + leftFork.getForkName() + " и " + rightFork.getForkName());
                Thread.sleep(10);
                leftFork.setInUse(false);
                rightFork.setInUse(false);
                cdl.countDown();
            }
        }
    }

    public  void  eat() throws InterruptedException {
        while (true) {
            if (!leftFork.inUse && !rightFork.inUse) {
                leftFork.setInUse(true);
                rightFork.setInUse(true);
                synchronized (leftFork) {
                    synchronized (rightFork) {
                        System.out.println("Кушает " + name + " вилками:" + leftFork.getForkName() + " и " + rightFork.getForkName());
                        Thread.sleep(10);
                    }
                }
                break;
            }
        }
    }

    @Override
    public void run() {
        while (cdl.getCount() > 1) {
            try {
                eat();
                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " накушался!");
    }
}
